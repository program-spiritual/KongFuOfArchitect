## 打包JRE

前面讲了，为了支持模块化，
Java 9首先带头把自己的一个巨大无比的rt.jar拆成了几十个.jmod模块，
原因就是，运行Java程序的时候，实际上我们用到的JDK模块，并没有那么多。
不需要的模块，完全可以删除。

过去发布一个Java应用程序，要运行它，必须下载一个完整的JRE，再运行jar包。
而完整的JRE块头很大，有100多M。怎么给JRE瘦身呢？

现在，JRE自身的标准库已经分拆成了模块，只需要带上程序用到的模块，
其他的模块就可以被裁剪掉。

怎么裁剪JRE呢？

并不是说把系统安装的JRE给删掉部分模块，而是“复制”一份JRE，但只带上用到的模块。

为此，JDK提供了jlink命令来干这件事。命令如下：
```shell script

 jlink --module-path hello.jmod --add-modules java.base,java.xml,hello.world --output jre/

```

我们在--module-path参数指定了我们自己的模块hello.jmod，
然后，在--add-modules参数中指定了我们用到的3个模块java.base、java.xml和hello.world，
用,分隔。最后，在--output参数指定输出目录。

现在，在当前目录下，我们可以找到jre目录，
这是一个完整的并且带有我们自己hello.jmod模块的JRE。

试试直接运行这个JRE：

```shell script
 jre/bin/java --module hello.world
```
xml, xml

要分发我们自己的Java应用程序，只需要把这个jre目录打个包给对方发过去，对方直接运行上述命令即可，既不用下载安装JDK，也不用知道如何配置我们自己的模块，极大地方便了分发和部署。