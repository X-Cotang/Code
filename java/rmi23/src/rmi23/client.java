package rmi23;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
 

public class client {
 
 
   private static final String HOST = "localhost";
   private static final int PORT = 1095;
   private static Registry registry;
 
   public static void main(String[] args) throws Exception {
 
      
       registry = LocateRegistry.getRegistry(HOST, PORT);
 
  
       sinhVien service = (sinhVien) registry.lookup(sinhVien.class.getSimpleName());
       System.out.println(sinhVien.class.getSimpleName());
       sinhVienClass a=service.getSv(1);
       if (a!=null) {
    	   System.out.println(a.getName());
       }
      

 
   }
}