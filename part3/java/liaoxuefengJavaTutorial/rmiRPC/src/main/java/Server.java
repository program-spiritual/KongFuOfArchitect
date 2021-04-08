import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

  public static void main(String[] args) {
    System.out.println("create World clock remote service...");
    // 实例化一个WorldClock:
    WorldClock worldClock = new WorldClockService();
    // 将此服务转换为远程服务接口:
    WorldClock skeleton = null;
    try {
      skeleton = (WorldClock) UnicastRemoteObject.exportObject(worldClock, 0);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    // 将RMI服务注册到1099端口:
    Registry registry = null;
    try {
      registry = LocateRegistry.createRegistry(1099);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    // 注册此服务，服务名为"WorldClock":
    try {
      registry.rebind("WorldClock", skeleton);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
}
