import java.rmi.*;
import java.io.*;

public class HelloClient{
  
  public static void main (String[] argv) {
    try {
      HelloInterface hello = (HelloInterface) Naming.lookup ("//localhost/Hello");
      switch(argv[0]){
        case "ContarLineas":
          System.out.println(hello.ContarLineas(argv[1]));
          break;

        case "ContarVocales":
          System.out.println(hello.ContarVocales(argv[1]));
          break;

        case "Escribe":
          hello.Escribe(argv[1], argv[2]);
          System.out.println("Escritura exitosa.");
          break;

        case "Imprimir":
          System.out.println(hello.Imprimir(argv[1]));
          break;

        case "Respaldar":
          hello.Respaldar(argv[1], argv[2]);
          System.out.println("Respaldo exitoso.");
          break;

        case "Copiar":
          hello.Copiar(argv[1], argv[2]);
          System.out.println("El archivo fue copiado exitosamente.");
          break;

        case "Renombrar":
          hello.Renombrar(argv[1], argv[2]); 
          System.out.println("El archivo fue renombrado correctamente.");
          break;
        
        case "Borrar":
          if(hello.Borrar(argv[1])){
            System.out.println("El archivo fue eliminado correctamente.");
          }else{
            System.out.println("Hubo un error al eliminar el archivo.");
          }
          break;
        
      }
    } catch (Exception e) {
      System.out.println ("HelloClient exception: " + e);
    }
  }
}