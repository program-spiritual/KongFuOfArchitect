public class ExtendDemo7 {
    public static void main(String[] args) {
//        在使用继承时，我们要注意逻辑一致性。
//这个Book类也有name字段，那么，我们能不能让Student继承自Book呢？
    }
}
//考察下面的Book类：

class Book {
    protected String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {}
}
//显然，从逻辑上讲，这是不合理的，Student不应该从Book继承，而应该从Person继承。
//
//究其原因，是因为Student是Person的一种，它们是is关系，而Student并不是Book。实际上Student和Book的关系是has关系。
class Student2 extends Book {
    protected int score;
}

//具有has关系不应该使用继承，而是使用组合，即Student可以持有一个Book实例：

class Student3 extends Person {
    protected Book book;
    protected int score;
}