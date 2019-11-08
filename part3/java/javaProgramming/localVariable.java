public class localVariable {
    public void pupAge() {
        int age=0;
        age = age + 7; // Error:(4, 15) java: 可能尚未初始化变量age
        System.out.println("Puppy age is : " + age);
    }

    public static void main(String[] args) {
        localVariable test = new localVariable();
        test .pupAge();
    }
}
