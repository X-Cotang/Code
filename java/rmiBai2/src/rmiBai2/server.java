package rmiBai2;


import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class server extends UnicastRemoteObject implements xuLi {
  protected server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PORT = 1091;
	private static Registry registry;

  public static void startRegistry() throws RemoteException {
      registry =  LocateRegistry.createRegistry(PORT);
  }

  public static void registerObject(String name, Remote remoteObj) throws RemoteException, AlreadyBoundException {
      registry.bind(name, remoteObj);
      System.out.println("Registered: " + name + " -> "
              + remoteObj.getClass().getName() + "[" + remoteObj + "]");
  }

  public static void main(String[] args) throws Exception {
      System.out.println("Server starting...");
      startRegistry();
      registerObject(xuLi.class.getSimpleName(), new server());


      System.out.println("Server started!");
  }

@Override
public int tinh(int a) throws RemoteException {
	// TODO Auto-generated method stub
	return a*a;
}

}