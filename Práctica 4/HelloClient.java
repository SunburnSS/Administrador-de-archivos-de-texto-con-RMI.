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
      }
    } catch (Exception e) {
      System.out.println ("HelloClient exception: " + e);
    }
  }
}