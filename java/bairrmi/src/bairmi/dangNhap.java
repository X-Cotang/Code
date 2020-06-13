package bairmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface dangNhap extends Remote{
public boolean dN(String user,String pass)  throws RemoteException;
}
