在Java中，我们经常听到 `classpath` 这个东西。
网上有很多关于“如何设置classpath”的文章，但大部分设置都不靠谱。

## 到底什么是classpath？

`classpath` 是JVM用到的一个环境变量，它用来指示JVM如何搜索class。

因为Java是编译型语言，源码文件是 `.java `，
而编译后的 `.class `文件才是真正可以被JVM执行的字节码。
因此，JVM需要知道，如果要加载一个` abc.xyz.Hello `的类，
应该去哪搜索对应的 `Hello.class ` 文件。

所以，`classpath`就是一组目录的集合，它设置的搜索路径与操作系统相关。
例如，在Windows系统上，用 `; `分隔，带空格的目录用 `""` 括起来，可能长这样：

```text
C:\work\project1\bin;C:\shared;"D:\My Documents\project1\bin"
```

在Linux系统上，用:分隔，可能长这样：

```text
/usr/shared:/usr/local/bin:/home/liaoxuefeng/bin

```
现在我们假设 `classpath `是`.;C:\work\project1\bin;C:\shared`，
当JVM在加载 `abc.xyz.Hello` 这个类时，会依次查找：

```text
<当前目录>\abc\xyz\Hello.class

C:\work\project1\bin\abc\xyz\Hello.class

C:\shared\abc\xyz\Hello.class
```


注意到 `.` 代表当前目录。如果JVM在某个路径下找到了对应的class文件，就不再往后继续搜索。如果所有路径下都没有找到，就报错。

classpath的设定方法有两种：

在系统环境变量中设置classpath环境变量，不推荐；

我们强烈不推荐在系统环境变量中设置classpath，那样会污染整个系统环境。
在启动JVM时设置classpath才是推荐的做法。
实际上就是给java命令传入 `-classpath` 或 `-cp` 参数：

```shell script
java -classpath .;C:\work\project1\bin;C:\shared abc.xyz.Hello

```

或者使用 `-cp` 的简写：

```shell script
java -cp .;C:\work\project1\bin;C:\shared abc.xyz.Hello
```

没有设置系统环境变量，也没有传入 `-cp` 参数，
那么JVM默认的classpath为 `.` ，即当前目录：

```text

java abc.xyz.Hello
```
上述命令告诉JVM只在当前目录搜索 `Hello.class` 。

在IDE中运行Java程序，
IDE自动传入的 `-cp` 参数是当前工程的 `bin` 目录和引入的jar包。

通常，我们在自己编写的class中，会引用Java核心库的class，
例如，String、ArrayList等。这些class应该上哪去找？

有很多“如何设置classpath”的文章会告诉你把JVM自带的 `rt.jar` 放入 `classpath` ，
但事实上，根本不需要告诉JVM如何去Java核心库查找class，
JVM怎么可能笨到连自己的核心库在哪都不知道？
不要把任何Java核心库添加到classpath中！
JVM根本不依赖 `classpath` 加载核心库！
更好的做法是，不要设置classpath！默认的当前目录 `.` 对于绝大多数情况都够用了

