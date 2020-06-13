package udp;
import java.io.IOException;

import java.net.DatagramPacket;

import java.net.DatagramSocket;

import java.net.InetAddress;

public class server {

public static void main(String []args) throws IOException

{
	DatagramSocket serverSocket = new DatagramSocket(1026);
	System.out.println("Ss");
	byte iClnt[];
	iClnt = new byte[1024];
	int leng1 = iClnt.length;
	DatagramPacket fromClient1 = new DatagramPacket(iClnt, leng1);
	serverSocket.receive(fromClient1);
	String data1;
	data1="Nhap vao truy van: ";
	byte ou2Client[];
	ou2Client = data1.getBytes();
	leng1 = ou2Client.length;
	InetAddress address = fromClient1.getAddress();
	int port = fromClient1.getPort();
	DatagramPacket toClient = new DatagramPacket(ou2Client, leng1, address, port);
	serverSocket.send(toClient);
	fromClient1 = new DatagramPacket(iClnt, leng1);
	serverSocket.receive(fromClient1);
	String c=(new String(fromClient1.getData(),0,iClnt.length)).trim();
	if (c.equals("ngay")) {
		data1=java.time.LocalDate.now().toString();
	}
	else if(c.equals("gio")) {
		data1=java.time.LocalTime.now().toString();
	}
	else if(c.equals("ngay va gio")) {
		data1=java.time.LocalDateTime.now().toString();
	}
	else {
		data1="not found";
	
	}
	//data1 ="Rat vui duoc ket noi voi ten "+ (new String(fromClient1.getData(),0,iClnt.length)).trim();
	ou2Client = data1.getBytes();
	toClient = new DatagramPacket(ou2Client, ou2Client.length, address, port);
	serverSocket.send(toClient);
	serverSocket.close();
}
}