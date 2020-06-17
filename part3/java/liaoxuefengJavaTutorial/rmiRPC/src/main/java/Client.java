import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;

public class Client {
    public static void main(String[] args) {
        // 连接到服务器localhost，端口1099:
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry("localhost", 1099);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        // 查找名称为"WorldClock"的服务并强制转型为WorldClock接口:
        WorldClock worldClock = null;
        try {
            worldClock = (WorldClock) registry.lookup("WorldClock");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        // 正常调用接口方法:
        LocalDateTime now = null;
        try {
            now = worldClock.getLocalDateTime("Asia/Shanghai");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        // 打印调用结果:
        System.out.println(now);
    }
}
