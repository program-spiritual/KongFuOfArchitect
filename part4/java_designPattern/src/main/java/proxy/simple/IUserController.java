package proxy.simple;

public interface IUserController {
    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);
}
