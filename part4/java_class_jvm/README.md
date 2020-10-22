## 类与虚拟机


### 类加载过程

- 加载
  - `Java` 将字节码数据从不同的数据源读取到 `JVM` 中，并映射为 `JVM` 认可的数据结构（`Class` 对象）
    - 数据源可能是各种各样的形态，如 `jar` 文件、`class` 文件，甚至是网络数据源
- 链接
  - 把原始的类定义信息平滑地转化入 `JVM` 运行的过程中
  - 验证
    - 核验字节信息是符合 `Java` 虚拟机规范的，否则就被认为是 `VerifyError`
  - 准备 
    - 创建类或接口中的静态变量，并初始化静态变量的初始值
    - 分配所需要的内存空间，不会去执行更进一步的 `JVM` 指令  
  - 解析
    - 将常量池中的符号引用替换为直接引用  
- 初始化
  - 真正去执行类初始化的代码逻辑
    - 静态字段赋值的动作
    - 执行类定义中的静态初始化块内的逻辑
    - 父类型的初始化逻辑优先于当前类型的逻辑
    
### 双亲委派模型    
当类加载器（`Class-Loader`）试图加载某个类型的时候，除非父加载器找不到相应类型，否则尽量将这个任务代理给当前加载器的父加载器去做。

- 作用
  - 避免重复加载 Java 类型
  
示例：


```java

public class CLPreparation {
    public static int a = 100;
    public static final int INT_CONSTANT = 1000;
    public static final Integer INTEGER_CONSTANT = 10000;
}
```  

编译为字节码后并输出字节码文件的信息：

```bash 

Javap –v CLPreparation.class
```

输出的内容信息：

```text
  static {};
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=1, locals=0, args_size=0
         0: bipush        100
         2: putstatic     #2                  // Field a:I
         5: sipush        10000
         8: invokestatic  #3                  // Method java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        11: putstatic     #4                  // Field INTEGER_CONSTANT:Ljava/lang/Integer;
        14: return
      LineNumberTable:
        line 3: 0
        line 5: 5
}
```

普通原始类型静态变量和引用类型（即使是常量），是需要额外调用 `putstatic` 等 `JVM` 指令的

### `Java 8` 以前各种类加载器的结构

- 启动类加载器

  - 加载 `jre/lib` 下面的 `jar` 文件，如 `rt.jar`。它是个超级公民
  
修改 `JDK` 的基础代码:

```bash 

# 指定新的bootclasspath，替换java.*包的内部实现
java -Xbootclasspath:<your_boot_classpath> your_App
 
# a意味着append，将指定目录添加到bootclasspath后面
java -Xbootclasspath/a:<your_dir> your_App
 
# p意味着prepend，将指定目录添加到bootclasspath前面
java -Xbootclasspath/p:<your_dir> your_App
```
  
- 扩展类加载器

  - 加载我们放到 `jre/lib/ext/` 目录下面的 `jar` 包，这就是所谓的 `extension` 机制。  
  - 覆盖方式：设置 `java.ext.dirs`
 
- 应用类加载器

  - 加载我们最熟悉的 `classpath` 的内容  
  - 系统（`System`）类加载器
    - 默认就是 `JDK` 内建的应用类加载器
 
修改 `JDK` 的内建类加载器：

```java

java -Djava.system.class.loader=com.yourcorp.YourClassLoader HelloWorld
```    

### 类加载机制有三个基本特征

- 双亲委派模型
  - 特殊情况
     - `JNDI`、`JDBC`、文件系统、`Cipher` 都是是可能要加载用户代码的
       - 利用所谓的上下文加载器
- 可见性
  - 子类加载器可以访问父加载器加载的类型
  - 反向不行
- 单一性
  - 父加载器的类型对于子加载器是可见的
  - 父加载器中加载过的类型，就不会在子加载器中重复加载
  - 类加载器“邻居”间，同一类型仍然可以被加载多次，因为互相并不可见。
  

### `JAVA 9` 之后的类加载器

对相应模块的修补：

确认要修改的类文件已经编译好，并按照对应模块（假设是 java.base）结构存放  

```bash

java --patch-module java.base=your_patch yourApp
```
- 扩展类加载器被重命名为平台类加载器
- 部分不需要 `AllPermission` 的 `Java` 基础模块，被降级到平台类加载器中，相应的权限也被更精细粒度地限制起来。
- `rt.jar` 和 `tools.jar` 同样是被移除了！
- 增加了 `Layer` 的抽象， `JVM` 启动默认创建 `BootLayer`


目前的 JVM 内部结构就变成了下面的层次，
内建类加载器都在 `BootLayer` 中，
其他 `Layer` 内部有自定义的类加载器，
不同版本模块可以同时工作在不同的 `Layer`

![](src/main/resources/img/jvm_inner.png)


### 自定义类加载器

常见场景

- 实现类似进程内隔离，类加载器实际上用作不同的命名空间，以提供类似容器、模块化的效果。
- 应用需要从不同的数据源获取类定义信息
- 需要自己操纵字节码，动态修改或者生成类型

自定义类加载过程：

1. 通过指定名称，找到其二进制实现
2. 创建 `Class` 对象，并完成类加载过程


有什么通用办法，不需要代码和其他工作量，就可以降低类加载的开销呢？

- AOT
  - 直接编译成机器码，降低的其实主要是解释和编译开销
- `AppCDS`（Application Class-Data Sharing）

`AppCDS` 基本原理和工作过程：

-  JVM 将类信息加载， 解析成为元数据
- 根据需求是否需要修改进行分类：
  - `Read-Only` 部分
  - `Read-Write` 部分
  
这些元数据直接存储在文件系统中，作为所谓的 `Shared Archive`

命令：

```bash

Java -Xshare:dump -XX:+UseAppCDS -XX:SharedArchiveFile=<jsa>  \
         -XX:SharedClassListFile=<classlist> -XX:SharedArchiveConfigFile=<config_file>
```

应用程序启动时，指定归档文件，并开启 `AppCDS`:

```bash

Java -Xshare:on -XX:+UseAppCDS -XX:SharedArchiveFile=<jsa> yourApp
```

`JVM` 会通过内存映射技术，直接映射到相应的地址空间，免除了类加载、解析等各种开销。


### 动态生成 `Java` 类

使用 `Java Compiler API`

`JDK` 提供的标准 `API`，里面提供了与 `javac` 对等的编译器功能

[文档](https://docs.oracle.com/javase/9/docs/api/javax/tools/package-summary.html)

如何让 `JVM` 加载字节码？
- 符合 `JVM` 规范的字节码
- 利用 `Java` 字节码操纵工具和类库来实现
  - [ASM](https://asm.ow2.io/)
  - [javassist](http://www.javassist.org/)

### 类从字节码到 `Class` 对象的转换

```java

protected final Class<?> defineClass(String name, byte[] b, int off, int len,
                                   ProtectionDomain protectionDomain)
protected final Class<?> defineClass(String name, java.nio.ByteBuffer b,
                                   ProtectionDomain protectionDomain)
```

`ProxyGenerator` 生成字节码，并以 byte 数组的形式保存，然后通过调用 `Unsafe` 提供的 `defineClass` 入口。

```java

byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
      proxyName, interfaces.toArray(EMPTY_CLASS_ARRAY), accessFlags);
try {
  Class<?> pc = UNSAFE.defineClass(proxyName, proxyClassFile,
                                   0, proxyClassFile.length,
                                   loader, null);
  reverseProxyCache.sub(pc).putIfAbsent(loader, Boolean.TRUE);
  return pc;
} catch (ClassFormatError e) {
// 如果出现ClassFormatError，很可能是输入参数有问题，比如，ProxyGenerator有bug
}
```

使用硬编码的方式生成字节码：


```java
import java.io.DataOutputStream;
import java.io.IOException;

import static sun.tools.java.RuntimeConstants.opc_wide;

public class GenerateHardCodedBitCoce {
    public static void main(String[] args) {

    }

    private void codeLocalLoadStore(int lvar, int opcode, int opcode_0, DataOutputStream out) throws IOException {
        assert lvar >= 0 && lvar <= 0xFFFF;
        // 根据变量数值，以不同格式，dump操作码
        if (lvar <= 3) {
            out.writeByte(opcode_0 + lvar);
        } else if (lvar <= 0xFF) {
            out.writeByte(opcode);
            out.writeByte(lvar & 0xFF);
        } else {
            // 使用宽指令修饰符，如果变量索引不能用无符号byte
            out.writeByte(opc_wide);
            out.writeByte(opcode);
            out.writeShort(lvar & 0xFFFF);
        }
    }
}

```
普通的 `Java` 动态代理，其实现过程可以简化成为:

- 提供一个基础的接口，作为被调用类型和代理类之间的统一入口
- 实现 `InvocationHandler` ，对代理对象方法的调用，会被分派到其 `invoke` 方法来真正实现动作。
- 通过 `Proxy` 类，调用其 `newProxyInstance` 方法，生成一个实现了相应基础接口的代理类实例

动态代码生成是具体发生在什么阶段?

> 是在 `newProxyInstance` 生成代理类实例的时候

第一步，生成对应的类:

```java

ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

cw.visit(V1_8,                      // 指定Java版本
      ACC_PUBLIC,               // 说明是public类型
        "com/mycorp/HelloProxy",  // 指定包和类的名称
      null,                     // 签名，null表示不是泛型
      "java/lang/Object",               // 指定父类
      new String[]{ "com/mycorp/Hello" }); // 指定需要实现的接口
```

按照需要为代理对象实例，生成需要的方法和逻辑:

```java

MethodVisitor mv = cw.visitMethod(
      ACC_PUBLIC,               // 声明公共方法
      "sayHello",               // 方法名称
      "()Ljava/lang/Object;",   // 描述符
      null,                     // 签名，null表示不是泛型
      null);                      // 可能抛出的异常，如果有，则指定字符串数组

mv.visitCode();
// 省略代码逻辑实现细节
cw.visitEnd();                      // 结束类字节码生成
```

字节码操纵技术，除了动态代理，还可以应用在什么地方？

- 各种 Mock 框架
- ORM 框架
- IOC 容器
- 部分 Profiler 工具，或者运行时诊断工具等
- 生成形式化代码的工具