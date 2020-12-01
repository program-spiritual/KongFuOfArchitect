package proxy.simple;

public class Demo {
    public static void main(String[] args) {
        //UserControllerProxy使用举例//因为原始类和代理类实现相同的接口，是基于接口而非实现编程
        //将UserController类对象替换为UserControllerProxy类对象，不需要改动太多代码
        IUserController userController = new UserControllerProxy(new UserController());
    }
}
