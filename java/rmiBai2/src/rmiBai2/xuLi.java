package rmiBai2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface xuLi extends Remote {
public int tinh(int a) throws RemoteException;
}
