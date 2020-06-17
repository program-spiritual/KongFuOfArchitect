import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public interface WorldClock extends Remote {
    LocalDateTime getLocalDateTime(String zoneId) throws RemoteException;
}
