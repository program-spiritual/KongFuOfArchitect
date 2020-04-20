如果有很多 `.class` 文件，散落在各层目录中，肯定不便于管理。如果能把目录打一个包，变成一个文件，就方便多了。

jar包就是用来干这个事的，它可以把 `package` 组织的目录层级，以及各个目录下的所有文件（包括 `.class` 文件和其他文件）都打成一个jar文件，
这样一来，无论是备份，还是发给客户，就简单多了。

 `jar` 包实际上就是一个 `zip` 格式的压缩文件，而`jar包相当于目录`。如果我们要执行一个 `jar` 包的class，就可以把 `jar` 包放到 `classpath` 中：
 
 ```shell script
 java -cp ./hello.jar abc.xyz.Hello
```

这样JVM会自动在 `hello.jar` 文件里去搜索某个类。

那么问题来了：如何创建jar包？

因为 `jar` 包就是zip包，所以，直接在资源管理器中，找到正确的目录，点击右键，在弹出的快捷菜单中选择“发送到”，“压缩(zipped)文件夹”，就制作了一个`zip`文件。
然后，把后缀从 `.zip` 改为 `.jar` ，一个 `jar ` 包就创建成功。
假设编译输出的目录结构是这样：

```text

package_sample
└─ bin
   ├─ hong
   │  └─ Person.class
   │  ming
   │  └─ Person.class
   └─ mr
      └─ jun
         └─ Arrays.class

```

这里需要特别注意的是，jar包里的第一层目录，不能是`bin`，而应该是`hong、ming、mr`

说明打包打得有问题，JVM仍然无法从jar包中查找正确的class，
原因是hong.Person必须按`hong/Person.class`存放，而不是`bin/hong/Person.class`。

jar包还可以包含一个特殊的`/META-INF/MANIFEST.MF`文件，`MANIFEST.MF`是纯文本，
可以指定`Main-Class`和其它信息。JVM会自动读取这个`MANIFEST.MF`文件，
如果存在`Main-Class`，我们就不必在命令行指定启动的类名，而是用更方便的命令：
```text
java -jar hello.jar

```
jar包还可以包含其它`jar`包，这个时候，就需要在`MANIFEST.MF`文件里配置`classpath`了。

在大型项目中，不可能手动编写`MANIFEST.MF`文件，再手动创建`zip`包。Java社区提供了大量的开源构建工具，例如`Maven`，可以非常方便地创建jar包。