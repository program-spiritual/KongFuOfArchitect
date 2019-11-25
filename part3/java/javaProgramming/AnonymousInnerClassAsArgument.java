interface Message{
    String greeting();
}
public class AnonymousInnerClassAsArgument {
    // method which accepts the object of interface Message
    public void displayMessage(Message m) {
        System.out.println(m.greeting() +
                ", This is an example of anonymous inner class as an argument");
    }

    public static void main(String args[]) {
        // Instantiating the class
        AnonymousInnerClassAsArgument obj = new AnonymousInnerClassAsArgument();

        // Passing an anonymous inner class as an argument
        obj.displayMessage(new Message() {
            public String greeting() {
                return "Hello";
            }
        });
    }
}
