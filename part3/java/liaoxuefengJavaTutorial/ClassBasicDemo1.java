public class ClassBasicDemo1 {
    public static void main(String[] args) {
//定义了class，只是定义了对象模版，而要根据对象模版创建出真正的对象实例，必须用new操作符。
//
//new操作符可以创建一个实例，然后，我们需要定义一个引用类型的变量来指向这个实例：
        Person ming = new Person();
//        上述代码创建了一个Person类型的实例，并通过变量ming指向它。
//        注意区分Person ming是定义Person类型的变量ming，而new Person()是创建Person实例。
//        有了指向这个实例的变量，我们就可以通过这个变量来操作实例。访问实例变量可以用变量.字段，例如：
        ming.name = "Xiao Ming"; // 对字段name赋值
        ming.age = 12; // 对字段age赋值
        System.out.println(ming.name); // 访问字段name

        Person hong = new Person();
        hong.name = "Xiao Hong";
        hong.age = 15;
        /*
        * 上述两个变量分别指向两个不同的实例，它们在内存中的结构如下：

            ┌──────────────────┐
ming ──────>│Person instance   │
            ├──────────────────┤
            │name = "Xiao Ming"│
            │age = 12          │
            └──────────────────┘
            ┌──────────────────┐
hong ──────>│Person instance   │
            ├──────────────────┤
            │name = "Xiao Hong"│
            │age = 15          │
            └──────────────────┘
两个instance拥有class定义的name和age字段，且各自都有一份独立的数据，互不干扰。
        *
        * */
    }
}

// 在Java中，创建一个类，例如，给这个类命名为Person，就是定义一个class

class Person{
    public String name;
    public Integer age;
//    public是用来修饰字段的，它表示这个字段可以被外部访问。
}

//一个class可以包含多个字段（field），字段用来描述一个类的特征。
//上面的Person类，我们定义了两个字段，一个是String类型的字段，命名为name，一个是int类型的字段，命名为age。
//因此，通过class，把一组数据汇集到一个对象上，实现了数据封装。