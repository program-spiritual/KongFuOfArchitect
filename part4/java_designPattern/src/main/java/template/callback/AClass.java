package template.callback;

public class AClass {
    public static void main(String[] args) {
        BClass b = new BClass();
        b.process(new ICallback() {
            //回调对象
            @Override
            public void methodToCallback() {
                System.out.println("Call back me.");
            }
        });
    }
}
