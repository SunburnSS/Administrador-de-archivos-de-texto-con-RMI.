import java.io.FileNotFoundException;
import java.rmi.*;
/**
 * Remote Interface for the "Hello, world!" example.
 */

public interface HelloInterface extends Remote {

  public String say() throws RemoteException;

  public int suma() throws RemoteException;

  public int ContarLineas() throws RemoteException;

  public int ContarVocales() throws RemoteException;

  public void Escribe() throws RemoteException;

  public String Imprimir() throws RemoteException;

  public void Respaldar() throws RemoteException;

  public void Copiar() throws RemoteException;

  public boolean Renombrar() throws RemoteException;

  public boolean Borrar() throws RemoteException;


}