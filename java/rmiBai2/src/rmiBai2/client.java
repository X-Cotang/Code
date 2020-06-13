package rmiBai2;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.Scanner;


 

public class client {
 
 
   private static final String HOST = "localhost";
   private static final int PORT = 1091;
   private static Registry registry;
 
   public static void main(String[] args) throws Exception {
 
      
       registry = LocateRegistry.getRegistry(HOST, PORT);
 
  
       xuLi service = (xuLi) registry
               .lookup(xuLi.class.getSimpleName());
       System.out.println("Nhap vao so:");
       Scanner sc=new Scanner(System.in);
       int a=sc.nextInt();
       System.out.println(service.tinh(a));
       

 
   }
}