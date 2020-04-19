public class PolymorphismDemo4 {
    public static void main(String[] args) {
        var student = new Student5("James");
        System.out.println(student.hello());
    }
}

class Person13 {
    public Person13(String name) {
        this.name = name;
    }

    protected String name;

    public String hello() {
        return "Hello, " + name;
    }
}

class Student5 extends Person13 {
    public Student5(String name) {
        super(name);
    }

    @Override
    public String hello() {
        // 调用父类的hello()方法:
        return super.hello() + "!";
    }
}