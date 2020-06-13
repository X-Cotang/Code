package kiemtra;

import java.io.Serializable;

public class sinhVien implements Serializable {
	private String ten;
	private int age;
	private int id;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}

	public sinhVien(String ten, int age, int id) {
		this.ten = ten;
		this.age = age;
		this.id = id;
	}
	
}
