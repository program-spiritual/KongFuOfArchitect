package ming;
// 导入完整类名:
import mr.jun.Arrays;
// 导入mr.jun包的所有class:
import mr.jun.*;
//我们一般不推荐这种写法，因为在导入了多个包后，很难看出Arrays类属于哪个包。
//
//还有一种import static的语法，它可以导入可以导入一个类的静态字段和静态方法：

public class Person {
    mr.jun.Arrays arrays = new mr.jun.Arrays();
//    很显然，每次写完整类名比较痛苦。
//
//因此，第二种写法是用import语句，导入小军的Arrays，然后写简单类名：
Arrays arrays2 = new Arrays();
//在写import的时候，可以使用*，表示把这个包下面的所有class都导入进来（但不包括子包的class）
}
