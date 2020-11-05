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


### 监控和诊断JVM堆内存堆外存

分析一个简单的 `Hello` 程序：

在源码目录下通过以下命令执行命令：

```bash 
java -XX:NativeMemoryTracking=summary -XX:+UnlockDiagnosticVMOptions -XX:+PrintNMTStatistics Hello
```

NMT 的输出: 

```text


Native Memory Tracking:

Total: reserved=10092994KB, committed=649038KB
-                 Java Heap (reserved=8388608KB, committed=528384KB)
                            (mmap: reserved=8388608KB, committed=528384KB) 
 
-                     Class (reserved=1056878KB, committed=4974KB)
                            (classes #487)
                            (  instance classes #413, array classes #74)
                            (malloc=110KB #539) 
                            (mmap: reserved=1056768KB, committed=4864KB) 
                            (  Metadata:   )
                            (    reserved=8192KB, committed=4352KB)
                            (    used=140KB)
                            (    free=4212KB)
                            (    waste=0KB =0.00%)
                            (  Class space:)
                            (    reserved=1048576KB, committed=512KB)
                            (    used=7KB)
                            (    free=505KB)
                            (    waste=0KB =0.00%)
 
-                    Thread (reserved=17482KB, committed=17482KB)
                            (thread #17)
                            (stack: reserved=17408KB, committed=17408KB)
                            (malloc=56KB #104) 
                            (arena=18KB #32)
 
-                      Code (reserved=247724KB, committed=7584KB)
                            (malloc=36KB #396) 
                            (mmap: reserved=247688KB, committed=7548KB) 
 
-                        GC (reserved=367866KB, committed=76178KB)
                            (malloc=22742KB #2190) 
                            (mmap: reserved=345124KB, committed=53436KB) 
 
-                  Compiler (reserved=167KB, committed=167KB)
                            (malloc=3KB #40) 
                            (arena=165KB #5)
 
-                  Internal (reserved=550KB, committed=550KB)
                            (malloc=518KB #915) 
                            (mmap: reserved=32KB, committed=32KB) 
 
-                    Symbol (reserved=1130KB, committed=1130KB)
                            (malloc=770KB #27) 
                            (arena=360KB #1)
 
-    Native Memory Tracking (reserved=126KB, committed=126KB)
                            (malloc=5KB #60) 
                            (tracking overhead=122KB)
 
-        Shared class space (reserved=11284KB, committed=11284KB)
                            (mmap: reserved=11284KB, committed=11284KB) 
 
-               Arena Chunk (reserved=974KB, committed=974KB)
                            (malloc=974KB) 
 
-                   Logging (reserved=5KB, committed=5KB)
                            (malloc=5KB #196) 
 
-                 Arguments (reserved=13KB, committed=13KB)
                            (malloc=13KB #418) 
 
-                    Module (reserved=59KB, committed=59KB)
                            (malloc=59KB #1038) 
 
-                 Safepoint (reserved=8KB, committed=8KB)
                            (mmap: reserved=8KB, committed=8KB) 
 
-           Synchronization (reserved=119KB, committed=119KB)
                            (malloc=119KB #1773) 


```

 参数

-  `-XX:NativeMemoryTracking=summary `

开启 NMT 并选择 summary 模式，

- `-XX:+UnlockDiagnosticVMOptions -XX:+PrintNMTStatistics`

在应用退出时打印 NMT 统计信息

- `Class` 内存占用，它所统计的就是 `Java` 类元数据所占用的空间
  - 调整参数： `-XX:MaxMetaspaceSize=value`
  
- 调整启动类加载器元数据区
  - `-XX:InitialBootClassLoaderMetaspaceSize=30720`
  
面对进程时间较为短暂的函数式服务，如何降低内存的占用率
- 降低其并行线程数目
- 切换 `GC` 类型

`JIT` 编译默认开启了 `TieredCompilation`

关闭 `TieredCompilation` 并 更换 `GC` 

```bash
java -XX:NativeMemoryTracking=summary -XX:+UnlockDiagnosticVMOptions -XX:+PrintNMTStatistics -XX:-TieredCompilation -XX:+UseParallelGC  Hello

```

输出内容如下：

```text
Native Memory Tracking:

Total: reserved=9862960KB, committed=874120KB
-                 Java Heap (reserved=8388608KB, committed=524288KB)
                            (mmap: reserved=8388608KB, committed=524288KB) 
 
-                     Class (reserved=1056879KB, committed=4975KB)
                            (classes #501)
                            (  instance classes #426, array classes #75)
                            (malloc=111KB #537) 
                            (mmap: reserved=1056768KB, committed=4864KB) 
                            (  Metadata:   )
                            (    reserved=8192KB, committed=4352KB)
                            (    used=121KB)
                            (    free=4231KB)
                            (    waste=0KB =0.00%)
                            (  Class space:)
                            (    reserved=1048576KB, committed=512KB)
                            (    used=6KB)
                            (    free=506KB)
                            (    waste=0KB =0.00%)
 
-                    Thread (reserved=12341KB, committed=12341KB)
                            (thread #11)
                            (stack: reserved=12288KB, committed=12288KB)
                            (malloc=40KB #74) 
                            (arena=13KB #23)
 
-                      Code (reserved=49562KB, committed=2542KB)
                            (malloc=26KB #318) 
                            (mmap: reserved=49536KB, committed=2516KB) 
 
-                        GC (reserved=341736KB, committed=316140KB)
                            (malloc=35256KB #185) 
                            (mmap: reserved=306480KB, committed=280884KB) 
 
-                  Compiler (reserved=164KB, committed=164KB)
                            (malloc=1KB #21) 
                            (arena=163KB #3)
 
-                  Internal (reserved=535KB, committed=535KB)
                            (malloc=503KB #882) 
                            (mmap: reserved=32KB, committed=32KB) 
 
-                    Symbol (reserved=1151KB, committed=1151KB)
                            (malloc=791KB #1389) 
                            (arena=360KB #1)
 
-    Native Memory Tracking (reserved=90KB, committed=90KB)
                            (malloc=3KB #42) 
                            (tracking overhead=87KB)
 
-        Shared class space (reserved=11284KB, committed=11284KB)
                            (mmap: reserved=11284KB, committed=11284KB) 
 
-               Arena Chunk (reserved=492KB, committed=492KB)
                            (malloc=492KB) 
 
-                   Logging (reserved=5KB, committed=5KB)
                            (malloc=5KB #196) 
 
-                 Arguments (reserved=13KB, committed=13KB)
                            (malloc=13KB #418) 
 
-                    Module (reserved=59KB, committed=59KB)
                            (malloc=59KB #1038) 
 
-                 Safepoint (reserved=8KB, committed=8KB)
                            (mmap: reserved=8KB, committed=8KB) 
 
-           Synchronization (reserved=33KB, committed=33KB)
                            (malloc=33KB #416) 

```

Thread 从 17 降到了 11

`Code` 统计信息，也就是 `CodeCache` 相关内存，即 `JIT compiler` 存储编译热点方法等信息的地方

设置初始值和最大值的参数

```text

## 初始值
-XX:InitialCodeCacheSize=value
## 保存code 缓存的大小
-XX:ReservedCodeCacheSize=value
```

我们进行下一步的实验：

```bash
java -XX:NativeMemoryTracking=summary -XX:+UnlockDiagnosticVMOptions -XX:+PrintNMTStatistics -XX:-TieredCompilation -XX:+UseParallelGC -XX:InitialCodeCacheSize=4096  Hello

```

这是实验的输出值：

```text
Native Memory Tracking:

Total: reserved=9862960KB, committed=872060KB
-                 Java Heap (reserved=8388608KB, committed=524288KB)
                            (mmap: reserved=8388608KB, committed=524288KB) 
 
-                     Class (reserved=1056879KB, committed=4975KB)
                            (classes #501)
                            (  instance classes #426, array classes #75)
                            (malloc=111KB #537) 
                            (mmap: reserved=1056768KB, committed=4864KB) 
                            (  Metadata:   )
                            (    reserved=8192KB, committed=4352KB)
                            (    used=121KB)
                            (    free=4231KB)
                            (    waste=0KB =0.00%)
                            (  Class space:)
                            (    reserved=1048576KB, committed=512KB)
                            (    used=6KB)
                            (    free=506KB)
                            (    waste=0KB =0.00%)
 
-                    Thread (reserved=12341KB, committed=12341KB)
                            (thread #11)
                            (stack: reserved=12288KB, committed=12288KB)
                            (malloc=40KB #74) 
                            (arena=13KB #23)
 
-                      Code (reserved=49562KB, committed=482KB)
                            (malloc=26KB #318) 
                            (mmap: reserved=49536KB, committed=456KB) 
 
-                        GC (reserved=341736KB, committed=316140KB)
                            (malloc=35256KB #185) 
                            (mmap: reserved=306480KB, committed=280884KB) 
 
-                  Compiler (reserved=164KB, committed=164KB)
                            (malloc=1KB #21) 
                            (arena=163KB #3)
 
-                  Internal (reserved=535KB, committed=535KB)
                            (malloc=503KB #883) 
                            (mmap: reserved=32KB, committed=32KB) 
 
-                    Symbol (reserved=1151KB, committed=1151KB)
                            (malloc=791KB #1389) 
                            (arena=360KB #1)
 
-    Native Memory Tracking (reserved=90KB, committed=90KB)
                            (malloc=3KB #42) 
                            (tracking overhead=87KB)
 
-        Shared class space (reserved=11284KB, committed=11284KB)
                            (mmap: reserved=11284KB, committed=11284KB) 
 
-               Arena Chunk (reserved=492KB, committed=492KB)
                            (malloc=492KB) 
 
-                   Logging (reserved=5KB, committed=5KB)
                            (malloc=5KB #196) 
 
-                 Arguments (reserved=13KB, committed=13KB)
                            (malloc=13KB #418) 
 
-                    Module (reserved=59KB, committed=59KB)
                            (malloc=59KB #1038) 
 
-                 Safepoint (reserved=8KB, committed=8KB)
                            (mmap: reserved=8KB, committed=8KB) 
 
-           Synchronization (reserved=33KB, committed=33KB)
                            (malloc=33KB #416) 
 

```

### 关于GC 

Remembered Set 通常都会占用 20%~30% 的堆空间。

#### Serial GC 

改为序列化的方式

增加以下的参数

```text

-XX:+UseSerialGC
```

运行

```bash
java -XX:NativeMemoryTracking=summary -XX:+UnlockDiagnosticVMOptions -XX:+PrintNMTStatistics -XX:-TieredCompilation -XX:+UseSerialGC -XX:InitialCodeCacheSize=4096   Hello

```

输出结果：
```text
Native Memory Tracking:

Total: reserved=9547523KB, committed=556623KB
-                 Java Heap (reserved=8388608KB, committed=524288KB)
                            (mmap: reserved=8388608KB, committed=524288KB) 
 
-                     Class (reserved=1056879KB, committed=4975KB)
                            (classes #501)
                            (  instance classes #426, array classes #75)
                            (malloc=111KB #536) 
                            (mmap: reserved=1056768KB, committed=4864KB) 
                            (  Metadata:   )
                            (    reserved=8192KB, committed=4352KB)
                            (    used=121KB)
                            (    free=4231KB)
                            (    waste=0KB =0.00%)
                            (  Class space:)
                            (    reserved=1048576KB, committed=512KB)
                            (    used=6KB)
                            (    free=506KB)
                            (    waste=0KB =0.00%)
 
-                    Thread (reserved=11313KB, committed=11313KB)
                            (thread #11)
                            (stack: reserved=11264KB, committed=11264KB)
                            (malloc=37KB #68) 
                            (arena=12KB #21)
 
-                      Code (reserved=49562KB, committed=482KB)
                            (malloc=26KB #318) 
                            (mmap: reserved=49536KB, committed=456KB) 
 
-                        GC (reserved=27336KB, committed=1740KB)
                            (malloc=24KB #118) 
                            (mmap: reserved=27312KB, committed=1716KB) 
 
-                  Compiler (reserved=164KB, committed=164KB)
                            (malloc=1KB #21) 
                            (arena=163KB #3)
 
-                  Internal (reserved=531KB, committed=531KB)
                            (malloc=499KB #813) 
                            (mmap: reserved=32KB, committed=32KB) 
 
-                    Symbol (reserved=1151KB, committed=1151KB)
                            (malloc=791KB #1389) 
                            (arena=360KB #1)
 
-    Native Memory Tracking (reserved=87KB, committed=87KB)
                            (malloc=3KB #35) 
                            (tracking overhead=85KB)
 
-        Shared class space (reserved=11284KB, committed=11284KB)
                            (mmap: reserved=11284KB, committed=11284KB) 
 
-               Arena Chunk (reserved=492KB, committed=492KB)
                            (malloc=492KB) 
 
-                   Logging (reserved=5KB, committed=5KB)
                            (malloc=5KB #196) 
 
-                 Arguments (reserved=13KB, committed=13KB)
                            (malloc=13KB #418) 
 
-                    Module (reserved=59KB, committed=59KB)
                            (malloc=59KB #1038) 
 
-                 Safepoint (reserved=8KB, committed=8KB)
                            (mmap: reserved=8KB, committed=8KB) 
 
-           Synchronization (reserved=33KB, committed=33KB)
                            (malloc=33KB #407) 

```

### `GC` 调优思路

#### 目标是什么？

- 内存占用（`footprint`: 英文直译是脚印）
- 延时（`latency`：直译是潜在因素）
- 吞吐量（`throughput`）

#### 其他因素

- `OOM` 也可能与不合理的 `GC` 相关参数有关
- 应用启动速度方面的需求

#### 调优思路：

- 理解应用需求和问题，确定调优目标。
- 掌握 `JVM` 和 `GC` 的状态，定位具体的问题，确定真的有 `GC` 调优的必要
  - jstat 等工具查看 GC 等相关状态
  - 开启 `GC` 日志，或者是利用操作系统提供的诊断工具
 
- 选择的 `GC` 类型是否符合我们的应用特征
  - 是 `Minor GC` 过长，还是 `Mixed GC` 等出现异常停顿情况
  - `CMS` 和 `G1` 都是更侧重于低延迟的 `GC`
  
- 分析确定具体调整的参数或者软硬件配置
- 验证是否达到调优目标，如果达到目标，即可以考虑结束调优


#### G1 GC 的内部结构和主要机制

- 其内部是类似棋盘状的一个个 `region` 组成
- `region` 的大小是一致的，数值是在 1M 到 32M 字节之间的一个 2 的幂值数  
- `G1` 会将超过 `region` 50% 大小的对象（在应用中，通常是 `byte` 或 `char` 数组）归类为 `Humongous`(巨大的) 对象
- Humongous region 算是老年代的一部分

##### 副作用

- `region` 大小和大对象很难保证一致，这会导致空间的浪费

##### `G1` 选择的是复合算法

- 在新生代，`G1` 采用的仍然是并行的复制算法，所以同样会发生 `Stop-The-World` 的暂停。
- 在老年代，大部分情况下都是并发标记，是增量进行的
- 人们喜欢把新生代 `GC`（`Young GC`）叫作 `Minor GC`
- 老年代 `GC` 叫作 `Major GC`
- `Minor GC` 仍然存在，虽然具体过程会有区别。涉及 `Remembered Set` 等相关处理
- 老年代回收，则是依靠 `Mixed GC`

具体的参数：

```text
# 触发阈值，并且设定最多被包含在一次 Mixed GC 中的 region 比例。
–XX:G1MixedGCLiveThresholdPercent
–XX:G1OldCSetRegionThresholdPercent
```

#### Remembered Set

- `G1` 的很多开销都是源自 `Remembered Set`

##### 问题的来源：

`Humongous` 对象的分配和回收

> `Humongous region` 作为老年代的一部分，通常认为它会在并发标记结束后才进行回收，但是在新版 G1 中，Humongous 对象回收采取了更加激进的策略。
>阻止它被回收的唯一可能，就是新生代是否有对象引用了它，但这个信息是可以在 Young GC 时就知道的

##### `G1` 的类型卸载有什么改进吗？

现代的 G1 已经不是如此了，8u40 以后，G1 增加并默认开启下面的选项

```text

-XX:+ClassUnloadingWithConcurrentMark
```

并发标记阶段结束后，JVM 即进行类型卸载.
最新的 JDK， Full GC 也是并行进行的了，在通用场景中的表现还优于 Parallel GC 的 Full GC 实现。

##### G1 调优建议

- 建议尽量升级到较新的 JDK 版本
- 掌握 `GC` 调优信息收集途径。掌握尽量全面、详细、准确的信息，是各种调优的基础，不仅仅是 GC 调优。

常用的选项：

```text

-XX:+PrintGCDetails
-XX:+PrintGCDateStamps
```

其他选项：特定问题的诊断都是要依赖这些选项

```text

-XX:+PrintAdaptiveSizePolicy // 打印G1 Ergonomics相关信息
```

引用清理不及时的情况：

```text
##打开

-XX:+PrintReferenceGC

##开启选项下面的选项进行并行引用处理

-XX:+ParallelRefProcEnabled
```
> `JDK 9` 中 `JVM` 和 `GC` 日志机构进行了重构，其实我前面提到的 `PrintGCDetails` 已经被标记为废弃，而 `PrintGCDateStamps` 已经被移除

可使用以下参数进行：

```text

java -Xlog:help
```

- `Young GC` 非常耗时，这很可能就是因为新生代太大了，我们可以：

```text
## 减小新生代的最小比例
-XX:G1NewSizePercent

## 降低其最大值
-XX:G1MaxNewSizePercent
```

##### Mixed GC 延迟较长

可以利用下面参数提高 Mixed GC 的个数

```text

-XX:G1MixedGCCountTarget
```