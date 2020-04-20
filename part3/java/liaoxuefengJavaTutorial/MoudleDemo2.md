运行模块
要运行一个jar，我们使用java -jar xxx.jar命令。要运行一个模块，我们只需要指定模块名。试试：
```shell script
$ java --module-path hello.jmod --module hello.world

```
结果是一个错误：
```shell script
Error occurred during initialization of boot layer
java.lang.module.FindException: JMOD format not supported at execution time: hello.jmod

```
原因是.jmod不能被放入--module-path中。换成.jar就没问题了：
```shell script
$ java --module-path hello.jar --module hello.world

```
xml, xml
那我们辛辛苦苦创建的hello.jmod有什么用？答案是我们可以用它来打包JRE。

