package kiemtra;

import java.rmi.Remote;

public interface action extends Remote {
	public void add(sinhVien sv);
	public String timKiem(int id);
	//public void xoa(int id);
}
