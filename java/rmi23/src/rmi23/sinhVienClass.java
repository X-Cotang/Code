package rmi23;

import java.io.Serializable;

public class sinhVienClass implements Serializable {
    private int id;
    private String name;
    private int age;
    sinhVienClass(String name,int age){
    	this.name=name;
    	this.age=age;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}

}
