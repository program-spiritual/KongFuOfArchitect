如果是自己开发的程序，除了一个自己的app.jar以外，还需要一堆第三方的jar包，运行一个Java程序，一般来说，命令行写这样：
```shell script
java -cp app.jar:a.jar:b.jar:c.jar com.liaoxuefeng.sample.Main
```
JVM自带的标准库rt.jar不要写到classpath中，写了反而会干扰JVM的正常运行。

如果漏写了某个运行时需要用到的jar，那么在运行期极有可能抛出`ClassNotFoundException`。

所以，jar只是用于存放class的容器，它并不关心class之间的依赖。

从Java 9开始引入的模块，主要是为了解决“依赖”这个问题。
如果`a.jar`必须依赖另一个`b.jar`才能运行，那我们应该给`a.jar`加点说明啥的，
让程序在编译和运行的时候能自动定位到`b.jar`，这种自带“依赖关系”的class容器就是模块。

为了表明Java模块化的决心，
从Java 9开始，原有的Java标准库已经由一个单一巨大的rt.jar分拆成了几十个模块，
这些模块以.jmod扩展名标识，可以在 `$JAVA_HOME/jmods` 目录下找到它们：

```text
java.base.jmod                           java.security.sasl.jmod                  jdk.editpad.jmod                         jdk.jconsole.jmod                        jdk.net.jmod
java.compiler.jmod                       java.smartcardio.jmod                    jdk.hotspot.agent.jmod                   jdk.jdeps.jmod                           jdk.nio.mapmode.jmod
java.datatransfer.jmod                   java.sql.jmod                            jdk.httpserver.jmod                      jdk.jdi.jmod                             jdk.rmic.jmod
java.desktop.jmod                        java.sql.rowset.jmod                     jdk.incubator.foreign.jmod               jdk.jdwp.agent.jmod                      jdk.scripting.nashorn.jmod
java.instrument.jmod                     java.transaction.xa.jmod                 jdk.incubator.jpackage.jmod              jdk.jfr.jmod                             jdk.scripting.nashorn.shell.jmod
java.logging.jmod                        java.xml.crypto.jmod                     jdk.internal.ed.jmod                     jdk.jlink.jmod                           jdk.sctp.jmod
java.management.jmod                     java.xml.jmod                            jdk.internal.jvmstat.jmod                jdk.jshell.jmod                          jdk.security.auth.jmod
java.management.rmi.jmod                 jdk.accessibility.jmod                   jdk.internal.le.jmod                     jdk.jsobject.jmod                        jdk.security.jgss.jmod
java.naming.jmod                         jdk.aot.jmod                             jdk.internal.opt.jmod                    jdk.jstatd.jmod                          jdk.unsupported.desktop.jmod
java.net.http.jmod                       jdk.attach.jmod                          jdk.internal.vm.ci.jmod                  jdk.localedata.jmod                      jdk.unsupported.jmod
java.prefs.jmod                          jdk.charsets.jmod                        jdk.internal.vm.compiler.jmod            jdk.management.agent.jmod                jdk.xml.dom.jmod
java.rmi.jmod                            jdk.compiler.jmod                        jdk.internal.vm.compiler.management.jmod jdk.management.jfr.jmod                  jdk.zipfs.jmod
java.scripting.jmod                      jdk.crypto.cryptoki.jmod                 jdk.jartool.jmod                         jdk.management.jmod
java.se.jmod                             jdk.crypto.ec.jmod                       jdk.javadoc.jmod                         jdk.naming.dns.jmod
java.security.jgss.jmod                  jdk.dynalink.jmod                        jdk.jcmd.jmod                            jdk.naming.rmi.jmod
```

这些.jmod文件每一个都是一个模块，模块名就是文件名。
例如：模块java.base对应的文件就是java.base.jmod。
模块之间的依赖关系已经被写入到模块内的module-info.class文件了。
所有的模块都直接或间接地依赖java.base模块，
只有java.base模块不依赖任何模块，
它可以被看作是“根模块”，好比所有的类都是从Object直接或间接继承而来。

把一堆class封装为jar仅仅是一个打包的过程，
而把一堆class封装为模块则不但需要打包，还需要写入依赖关系，
并且还可以包含二进制代码（通常是JNI扩展）。
此外，模块支持多版本，即在同一个模块中可以为不同的JVM提供不同的版本。

那么，我们应该如何编写模块呢？还是以具体的例子来说。首先，创建模块和原有的创建Java项目是完全一样的，以oop-module工程为例，它的目录结构如下：

```text

oop-module
├── bin
├── build.sh
└── src
    ├── com
    │   └── itranswarp
    │       └── sample
    │           ├── Greeting.java
    │           └── Main.java
    └── module-info.java

```
其中，bin目录存放编译后的class文件，src目录存放源码，按包名的目录结构存放
，仅仅在src目录下多了一个module-info.java这个文件，这就是模块的描述文件。在这个模块中，它长这样：

```java

module hello.world {
	requires java.base; // 可不写，任何模块都会自动引入java.base
	requires java.xml;


```

其中，module是关键字，后面的hello.world是模块的名称，它的命名规范与包一致。
花括号的requires xxx;表示这个模块需要引用的其他模块名。除了java.base可以被自动引入外，这里我们引入了一个java.xml的模块。

当我们使用模块声明了依赖关系后，才能使用引入的模块。例如，Main.java代码如下：

```java
package com.itranswarp.sample;

// 必须引入java.xml模块后才能使用其中的类:
import javax.xml.XMLConstants;

public class Main {
	public static void main(String[] args) {
		Greeting g = new Greeting();
		System.out.println(g.hello(XMLConstants.XML_NS_PREFIX));
	}
}
```

下面，我们用JDK提供的命令行工具来编译并创建模块。

首先，我们把工作目录切换到oop-module，在当前目录下编译所有的.java文件，并存放到bin目录下，命令如下：

```shell script
javac -d bin src/module-info.java src/com/itranswarp/sample/*.java
```

如果编译成功，现在项目结构如下：

```text
oop-module
├── bin
│   ├── com
│   │   └── itranswarp
│   │       └── sample
│   │           ├── Greeting.class
│   │           └── Main.class
│   └── module-info.class
└── src
    ├── com
    │   └── itranswarp
    │       └── sample
    │           ├── Greeting.java
    │           └── Main.java
    └── module-info.java
```
注意到src目录下的module-info.java被编译到bin目录下的module-info.class。


下一步，我们需要把bin目录下的所有class文件先打包成jar，在打包的时候，注意传入--main-class参数，让这个jar包能自己定位main方法所在的类：

```shell script
jar --create --file hello.jar --main-class com.itranswarp.sample.Main -C bin .
```

现在我们就在当前目录下得到了hello.jar这个jar包，它和普通jar包并无区别，
可以直接使用命令java -jar hello.jar来运行它。
但是我们的目标是创建模块，所以，继续使用JDK自带的jmod命令把一个jar包转换成模块：

```shell script
jmod create --class-path hello.jar hello.jmod
```
于是，在当前目录下我们又得到了hello.jmod这个模块文件，这就是最后打包出来的传说中的模块！