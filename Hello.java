import java.rmi.*;
import java.rmi.server.*;
import java.io.*;

/**
 * Aqui van todas las clases a usar
 */
public class Hello extends UnicastRemoteObject implements HelloInterface {

  public Hello() throws RemoteException {
    
  }

  public int ContarLineas(String archivo) throws RemoteException {
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

  public int ContarVocales(String archivo) throws RemoteException{
    String lineas = "";
    int Vocales = 0;
    File file = new File(archivo);
    FileReader fr = null;
    BufferedReader br = null;

    file = new File(archivo);
    try {
      fr = new FileReader(file);
      br = new BufferedReader(fr);
      try {
        while ((lineas = br.readLine()) != null) {
          String fraseMin = lineas.toLowerCase();

          for (int i = 0; i < fraseMin.length(); ++i) {
            switch (fraseMin.charAt(i)) {
              case 'a':

              case 'e':

              case 'i':

              case 'o':

              case 'u':

                Vocales++;
                break;
              default:
                // se ignoran las dem�s letras
            }
          }
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
    return Vocales;
  }

  public void Escribe(String archivo) throws RemoteException{
    File origen = new File(archivo);
    File destino = new File("escribe.txt");

    try {
      InputStream in = new FileInputStream(origen);
      OutputStream out = new FileOutputStream(destino);

      byte[] buf = new byte[1024];
      int len;

      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }

      in.close();
      out.close();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  public String Imprimir(String archivo) throws RemoteException{
    String lineas = "";
    String texto = "";
    File file = new File(archivo);
    FileReader fr = null;
    BufferedReader br = null;

    file = new File(archivo);
    try {
      fr = new FileReader(file);
      br = new BufferedReader(fr);
      try {
        while ((lineas = br.readLine()) != null) {
          texto = texto + lineas + "\n";
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
    return texto;
  }

  public void Respaldar(String archivo, String respaldo) throws RemoteException{
    String lineas = "";
    File file = new File(archivo);
    FileReader fr = null;
    BufferedReader br = null;

    FileWriter fichero = null;
    PrintWriter pw = null;

    try {
      fr = new FileReader(file);
      br = new BufferedReader(fr);

      fichero = new FileWriter(respaldo);
      pw = new PrintWriter(fichero);

      while ((lineas = br.readLine()) != null) {
        pw.println(lineas);
      } 
    } catch (Exception e) {
      System.out.println("Error al abrir el archivo.");
    } finally {
      try {
        if (null != fichero)
          fichero.close();
          fr.close();
      } catch (Exception e2) {
        System.out.println("Error al cerrar el archivo.");
      }
    }
  }

  public void Copiar(String archivo, String archivin) throws RemoteException{
    
    String lineas = "";
    File file = new File(archivo);
    FileReader fr = null;
    BufferedReader br = null;

    FileWriter fichero = null;
    PrintWriter pw = null;

    try {
      fr = new FileReader(file);
      br = new BufferedReader(fr);
      fichero = new FileWriter(archivin, true);
      pw = new PrintWriter(fichero);

      while ((lineas = br.readLine()) != null) {
        pw.println(lineas);
      }
    } catch (Exception e) {
      System.out.println("Error al abrir el archivo.");
    } finally {
      try {
        if (null != fichero)
          fichero.close();
          fr.close();
      } catch (Exception e2) {
        System.out.println("Error al cerrar el archivo.");
      }
    }
  }

  public void Renombrar(String archivo, String renombrado) throws RemoteException{
    String lineas = "";
    File file = new File(archivo);
    FileReader fr = null;
    BufferedReader br = null;

    FileWriter fichero = null;
    PrintWriter pw = null;

    try {
      fr = new FileReader(file);
      br = new BufferedReader(fr);
      
      fichero = new FileWriter(renombrado);
      pw = new PrintWriter(fichero);

      while ((lineas = br.readLine()) != null) {
        pw.println(lineas);
      }
    } catch (Exception e) {
      System.out.println("Error al abrir el archivo.");
    } finally {
      try {
        if (null != fichero)
          fichero.close();
          fr.close();
          file.delete();
      } catch (Exception e2) {
        System.out.println("Error al cerrar el archivo.");
      }
    }
  }

  public boolean Borrar(String archivo) throws RemoteException{
    File f = new File(archivo);
    return f.delete();
  }

}//End