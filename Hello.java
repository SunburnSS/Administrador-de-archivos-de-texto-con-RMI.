import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

/**
 * Aqui van todas las clases a usar
 */
public class Hello extends UnicastRemoteObject implements HelloInterface {
  private String archivo;

  public Hello(String archivin) throws RemoteException {
    archivo = archivin;
  }

  public String say() throws RemoteException {

    return archivo;
  }

  public int suma() throws RemoteException {
    return 5;
  }

  public int ContarLineas() throws RemoteException {
    int NumLineas = 0;
    String lineas = "";
    File file = new File(archivo);
    FileReader fr = null;
    BufferedReader br = null;

    file = new File(archivo);
    try {
      fr = new FileReader(file);
      br = new BufferedReader(fr);
      try {
        while ((lineas = br.readLine()) != null) {
          NumLineas++;
        }
      } catch (IOException e) {
        System.out.println("Error al leer la linea del archivo.");
      }
    } catch (FileNotFoundException e) {
      System.out.println("Error al abrir el archivo.");
    } finally {
      try {
        fr.close();
      } catch (IOException e) {
        System.out.println("Error al cerrar el archivo.");
      }
    }
    return NumLineas;
  }

}