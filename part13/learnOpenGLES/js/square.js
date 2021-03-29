const {mat4} = window.glMatrix
const vsSource = `
    attribute vec4 aVertexPosition;

    uniform mat4 uModelViewMatrix;
    uniform mat4 uProjectionMatrix;

    void main() {
      gl_Position = uProjectionMatrix * uModelViewMatrix * aVertexPosition;
    }
  `;

const fsSource = `
    void main() {
      gl_FragColor = vec4(1.0, 1.0, 1.0, 1.0);
    }
  `;


function OnDOMLoaded() {
  const CANVAS = document.getElementById('glcanvas')
  const GL_CONTEXT = CANVAS.getContext('webgl')
  if (!GL_CONTEXT) {
    alert('无法初始化WEBGL，你的浏览器或OS不支持')
    return
  }
  
  // 使用不透明全黑抹掉一切
  GL_CONTEXT.clearColor(0, 0, 0, 1)
  // 清除缓冲区
  GL_CONTEXT.clear(GL_CONTEXT.COLOR_BUFFER_BIT)
  
  // 调用代码
  const shaderProgram = initShaderProgram(GL_CONTEXT, vsSource, fsSource);
  // 将它们存储在一起以使它们易于传递
  const programInfo = {
    program: shaderProgram,
    attribLocations: {
      vertexPosition: GL_CONTEXT.getAttribLocation(shaderProgram, 'aVertexPosition'),
    },
    uniformLocations: {
      projectionMatrix: GL_CONTEXT.getUniformLocation(shaderProgram, 'uProjectionMatrix'),
      modelViewMatrix: GL_CONTEXT.getUniformLocation(shaderProgram, 'uModelViewMatrix'),
    },
  }
  //这里是我们调用例程的地方，该例程将构建将要绘制的所有对象。
  const buffers = initBuffers(GL_CONTEXT)
  //绘制场景
  drawScene(GL_CONTEXT, programInfo, buffers);
}

function drawScene(glContext, programInfo, buffers) {
  //  透明至黑色，完全不透明
  glContext.clearColor(0, 0, 0, 1)
  // 清除一切
  glContext.clearDepth(1);
  // 启用深度测试
  glContext.enable(glContext.DEPTH_TEST);
  // 近处的事物遮盖了远处的事物
  glContext.depthFunc(glContext.LEQUAL);
  // 绘制之前，清除画布
  glContext.clear(glContext.COLOR_BUFFER_BIT | glContext.DEPTH_BUFFER_BIT)
  //创建透视图矩阵，这是一个特殊的矩阵，用于模拟相机中透视图的变形。
  //我们的视场为45度，宽/高比//与画布的显示尺寸匹配//我们只希望看到距离相机0.1到100单位之间的对象。
  const fieldOfView = 45 * Math.PI / 180;   // 弧度
  const aspect = glContext.canvas.clientWidth / glContext.canvas.clientHeight;
  const zNear = 0.1;
  const zFar = 100.0;
  const projectionMatrix = mat4.create();
  //注意：glmatrix.js 始终将第一个参数//作为接收结果的目的地。
  mat4.perspective(projectionMatrix, fieldOfView, aspect, zNear, zFar);
  //将绘图位置设置为“标识”点，即场景的中心。
  const modelViewMatrix = mat4.create();
  mat4.translate(modelViewMatrix,     // 目标矩阵
    modelViewMatrix,     // 转换矩阵
    [-0.0, 0.0, -6.0]);  // 翻译数量
  //告诉 WebGL 如何从位置缓冲区中拉出位置 到 vertexPosition 属性中。
  {
    // 每次迭代提取3个值
    const numComponents = 3;
    const type = glContext.FLOAT;
    // 不规范
    const normalize = false;
    // 从一组值到下一组值要获得多少字节
    const stride = 0;
    // 缓冲区中从多少字节开始
    const offset = 0
    glContext.vertexAttribPointer(programInfo.attribLocations.vertexPosition, numComponents, type, normalize, stride, offset);
    glContext.enableVertexAttribArray(programInfo.attribLocations.vertexPosition);
  }
  // 告诉 WebGL 在绘图时使用我们的程序
  glContext.useProgram(programInfo.program)
  // 告诉 WebGL 在绘图时使用我们的程序
  // 设置着色器 uniform
  glContext.uniformMatrix4fv(
    programInfo.uniformLocations.projectionMatrix, false, projectionMatrix);
  glContext.uniformMatrix4fv(programInfo.uniformLocations.modelViewMatrix, false, modelViewMatrix);
  {
    const offset = 0
    const vertexCount = 4
    glContext.drawArrays(glContext.TRIANGLE_STRIP, offset, vertexCount)
  }
}

function initBuffers(glContext) {
  const positionBuffer = glContext.createBuffer();
  glContext.bindBuffer(glContext.ARRAY_BUFFER, positionBuffer);
  const vertices = [
    1.0, 1.0, 0.0,
    -1.0, 1.0, 0.0,
    1.0, -1.0, 0.0,
    -1.0, -1.0, 0.0
  ];
  glContext.bufferData(glContext.ARRAY_BUFFER, new Float32Array(vertices), glContext.STATIC_DRAW);
  return {
    position: positionBuffer
  }
}

// 创建指定类型的着色器，上传 source 源码并编译
function loadShader(glContext, type, source) {
  // 创建着色器
  const shader = glContext.createShader(type);
  // 将源发送到着色器对象
  glContext.shaderSource(shader, source);
  // 编译着色器程序
  glContext.compileShader(shader);
  // 查看是否成功编译
  if (!glContext.getShaderParameter(shader, glContext.COMPILE_STATUS)) {
    alert('编译着色器时发生错误: ' + glContext.getShaderInfoLog(shader));
    glContext.deleteShader(shader);
    return null;
  }
  return shader;
}

// 初始化着色器程序，让WebGL知道如何绘制我们的数据
function initShaderProgram(glContext, vsSource, fsSource) {
  const vertexShader = loadShader(glContext, glContext.VERTEX_SHADER, vsSource);
  const fragmentShader = loadShader(glContext, glContext.FRAGMENT_SHADER, fsSource);
  // 创建着色器程序
  const shaderProgram = glContext.createProgram();
  glContext.attachShader(shaderProgram, vertexShader);
  glContext.attachShader(shaderProgram, fragmentShader);
  glContext.linkProgram(shaderProgram);
  // 如果创建失败，那么提示
  if (!glContext.getProgramParameter(shaderProgram, glContext.LINK_STATUS)) {
    alert('无法初始化着色器程序: ' + glContext.getProgramInfoLog(shaderProgram));
    return null;
  }
  return shaderProgram;
}

