
public class taikhoan {
	private String tk;
	private String mk;
	private int sodu;
	private String hoten;
	private String stk;
	public String getTk() {
		return tk;
	}
	public void setTk(String tk) {
		this.tk = tk;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	public int getSodu() {
		return sodu;
	}
	public void setSodu(int sodu) {
		this.sodu = sodu;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getStk() {
		return stk;
	}
	public void setStk(String stk) {
		this.stk = stk;
	}
	public taikhoan(String tk, String mk, int sodu, String hoten, String stk) {
		super();
		this.tk = tk;
		this.mk = mk;
		this.sodu = sodu;
		this.hoten = hoten;
		this.stk = stk;
	}

}
