package builder.simple;

public class Demo {
    public static void main(String[] args) {

// 参数太多，导致可读性差、参数可能传递错误
//        ResourcePoolConfig config = new ResourcePoolConfig("dbconnectionpool", 16, null, 8, null, false, true, 10, 20, false, true);
        ResourcePoolConfig config = new ResourcePoolConfig("dbconnectionpool");
        config.setMaxTotal(16);
        config.setMaxIdle(8);
        System.out.println(config);
    }
}
