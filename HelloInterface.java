import java.io.FileNotFoundException;
import java.rmi.*;
/**
 * Remote Interface for the "Hello, world!" example.
 */

public interface HelloInterface extends Remote {

  public int ContarLineas(String archivo) throws RemoteException;

  public int ContarVocales(String archivo) throws RemoteException;

  public void Escribe(String archivo, String contenido) throws RemoteException;

  public String Imprimir(String archivo) throws RemoteException;

  public void Respaldar(String archivo, String respaldo) throws RemoteException;

  public void Copiar(String archivo, String archivin) throws RemoteException;

  public void Renombrar(String archivo, String renombrado) throws RemoteException;

  public boolean Borrar(String archivo) throws RemoteException;


}