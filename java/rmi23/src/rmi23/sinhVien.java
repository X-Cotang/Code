package rmi23;
import java.rmi.*;
public interface sinhVien extends Remote {
	public sinhVienClass getSv(int id) throws RemoteException;
	public void setSv(String name,int age) throws RemoteException;
	public void getSv(String name) throws RemoteException;
}
