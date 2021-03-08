import java.rmi.*;
import java.io.*;

public class HelloClient{
  
  public static void main (String[] argv) {
    try {
      HelloInterface hello = (HelloInterface) Naming.lookup ("//localhost/Hello");
      switch(argv[0]){
        case "suma":
          System.out.println(hello.suma());
          break;

        case "say":
          System.out.println(hello.say());
          break;

        case "ContarLineas":
          System.out.println(hello.ContarLineas());
          break;

        case "ContarVocales":
          System.out.println(hello.ContarVocales());
          break;

        case "Escribe":
          hello.Escribe();
          System.out.println("Escritura exitosa.");
          break;

        case "Imprimir":
          System.out.println(hello.Imprimir());
          break;

        case "Respaldar":
          hello.Respaldar();
          System.out.println("Respaldo exitoso.");
          break;

        case "Copiar":
          hello.Copiar();
          System.out.println("El archivo fue copiado exitosamente.");
          break;

        case "Renombrar":
          boolean correcto;
          correcto = hello.Renombrar();
          if(correcto){
            System.out.println("El archivo fue renombrado correctamente.");
          }else{
            System.out.println("Hubo un problema con el renombrado.");
          }
          break;
        
        case "Borrar":
          if(hello.Borrar()){
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