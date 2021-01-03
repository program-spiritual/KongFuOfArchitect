package pubSub.p2p;


import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserService userService; // 依赖注入
    private final List<RegObserver> regObservers = new ArrayList<>();

    public void setRegObservers(List<RegObserver> observers) {
        regObservers.addAll(observers);
    }

    public Long reigster(String telephone, String passwd) {
    //省略输入参数的校验代码
    // 省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, passwd);
        for (RegObserver observer : regObservers) {
            observer.handleRegSuccess(userId);
        }
        return userId;
    }
}
