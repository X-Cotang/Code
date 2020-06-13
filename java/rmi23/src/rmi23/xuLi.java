package rmi23;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class xuLi extends UnicastRemoteObject implements sinhVien {
	public static ArrayList<sinhVienClass> svList;
	protected xuLi(ArrayList<sinhVienClass> svList) throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		this.svList=svList;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public sinhVienClass getSv(int id) throws RemoteException {
		// TODO Auto-generated method stub
		for(sinhVienClass s:svList) {
			if(s.getAge()==id) {
				return s;
			}
		}
		return null;
	}

	@Override
	public void setSv(String name, int age) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSv(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
