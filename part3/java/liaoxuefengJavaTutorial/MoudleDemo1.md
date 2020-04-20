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
这些模块以.jmod扩展名标识，可以在$JAVA_HOME/jmods目录下找到它们：