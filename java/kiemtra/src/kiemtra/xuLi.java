package kiemtra;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class xuLi extends UnicastRemoteObject implements action {
	public static ArrayList<sinhVien> sv;
	protected xuLi() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		sv=new ArrayList<sinhVien>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void add(sinhVien sv) {
		// TODO Auto-generated method stub
		this.sv.add(sv);
	}

	@Override
	public String timKiem(int id) {
		// TODO Auto-generated method stub
		for(sinhVien s:sv) {
			if(s.getId()==id) {
				return "Tim thay";
			}
		}
		return "Khong tim thay";
	}
/*
	@Override
	public void xoa(int id) {
		// TODO Auto-generated method stub
		
	}
	*/

}
