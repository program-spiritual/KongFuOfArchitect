package multithreads.threadLocal;

public class UserContext implements AutoCloseable {
    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user) {
        ctx.set(user);
    }

    public static String currentUser() {
        return ctx.get();
    }

    @Override
    public void close() throws Exception {
        ctx.remove();
    }
}
