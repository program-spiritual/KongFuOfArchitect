public class PackageDemo1 {
    /**
     * 在前面的代码中，我们把类和接口命名为Person、Student、Hello等简单名字。
     *
     * 在现实中，如果小明写了一个Person类，小红也写了一个Person类，现在，小白既想用小明的Person，也想用小红的Person，怎么办？
     *
     * 如果小军写了一个Arrays类，恰好JDK也自带了一个Arrays类，如何解决类名冲突？
     *
     * 在Java中，我们使用package来解决名字冲突。
     *
     * Java定义了一种名字空间，称之为包：package。一个类总是属于某个包，类名（比如Person）只是一个简写，真正的完整类名是包名.类名。
     *
     * 例如：
     * */
    public static void main(String[] args) {

    }
}

/**
 * 例如：
 *
 * 小明的Person类存放在包ming下面，因此，完整类名是ming.Person；
 *
 * 小红的Person类存放在包hong下面，因此，完整类名是hong.Person；
 *
 * 小军的Arrays类存放在包mr.jun下面，因此，完整类名是mr.jun.Arrays；
 *
 * JDK的Arrays类存放在包java.util下面，因此，完整类名是java.util.Arrays。
 *
 * 在定义class的时候，我们需要在第一行声明这个class属于哪个包。
 *
 * 小明的Person.java文件：
 * package ming; // 申明包名ming
 *
 * public class Person {
 * }
 * 小军的Arrays.java文件：
 *
 * package mr.jun; // 申明包名mr.jun
 *
 * public class Arrays {
 * }
 * 在Java虚拟机执行的时候，JVM只看完整类名，因此，只要包名不同，类就不同。
 *
 * 包可以是多层结构，用.隔开。例如：java.util。
 * 要特别注意：包没有父子关系。java.util和java.util.zip是不同的包，两者没有任何继承关系。
 * 没有定义包名的class，它使用的是默认包，非常容易引起名字冲突，因此，不推荐不写包名的做法。
 *
 * 我们还需要按照包结构把上面的Java文件组织起来。假设以package_sample作为根目录，src作为源码目录，那么所有文件结构就是：
 *
 * package_sample
 * └─ src
 *     ├─ hong
 *     │  └─ Person.java
 *     │  ming
 *     │  └─ Person.java
 *     └─ mr
 *        └─ jun
 *           └─ Arrays.java
 *即所有Java文件对应的目录层次要和包的层次一致。
 *
 * 编译后的.class文件也需要按照包结构存放。如果使用IDE，把编译后的.class文件放到bin目录下，那么，编译的文件结构就是：
 * package_sample
 * └─ bin
 *    ├─ hong
 *    │  └─ Person.class
 *    │  ming
 *    │  └─ Person.class
 *    └─ mr
 *       └─ jun
 *          └─ Arrays.class
 *编译的命令相对比较复杂，我们需要在src目录下执行javac命令：
 *
 * javac -d ../bin ming/Person.java hong/Person.java mr/jun/Arrays.java
 *
 * 在IDE中，会自动根据包结构编译所有Java源码，所以不必担心使用命令行编译的复杂命令。
 * */

