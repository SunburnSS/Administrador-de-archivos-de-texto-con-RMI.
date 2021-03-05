import java.io.FileNotFoundException;
import java.rmi.*;
/**
 * Remote Interface for the "Hello, world!" example.
 */

public interface HelloInterface extends Remote {

  public String say() throws RemoteException;

  public int suma() throws RemoteException;

  public int ContarLineas() throws RemoteException, FileNotFoundException;

}