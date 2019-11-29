/*
*
<div onclick="console.log('div')">
  <p onclick="console.log('p')">
    Click here!
  </p>
</div>
*
* */
// 如果我们点击 p，我们会看到两个日志：p 和 div。在事件传播期间，有三个阶段：捕获、目标和冒泡。默认情况下，事件处理程序在冒泡阶段执行（除非将 useCapture 设置为 true）。它从嵌套最深的元素向外传播。
