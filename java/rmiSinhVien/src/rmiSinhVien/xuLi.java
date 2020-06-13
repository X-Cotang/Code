package rmiSinhVien;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface xuLi extends Remote
{
public int ten() throws RemoteException;
public void them() throws RemoteException;

}
