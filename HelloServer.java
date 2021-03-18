import java.io.*;
import java.rmi.*;

public class HelloServer{
  /**
   * Server program for the "Hello, world!" example.
   * @param argv The command line arguments which are ignored.
   */
  public static void main (String[] argv) {
    if(System.getSecurityManager() == null) {
         System.setSecurityManager(new SecurityManager());
    }
    try {
      Naming.rebind ("Hello", new Hello ());
      System.out.println ("Hello Server is ready.");
    } catch (Exception e) {
      System.out.println ("Hello Server failed: " + e);
    }
  }
}