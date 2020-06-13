package udp;
import java.io.DataInputStream;

import java.io.IOException;

import java.net.DatagramPacket;

import java.net.DatagramSocket;

import java.net.InetAddress;

import java.net.UnknownHostException;

public class client {

public static void main(String []args) throws IOException

{
	DatagramSocket ClientSocket = new DatagramSocket();
	DataInputStream inFromUser = new DataInputStream(System.in);
	String a;
	InetAddress address = InetAddress.getByName("localhost");
	int port = 1026;
	int leng1;
try

{
	a ="connect";
	byte b[];
	b = a.getBytes();
	leng1 = b.length;
	DatagramPacket toSv = new DatagramPacket(b, leng1, address, port);
	ClientSocket.send(toSv);
	byte infSv[];
	infSv = new byte[1024];
	leng1 = infSv.length;
	DatagramPacket fSv = new DatagramPacket(infSv, leng1);
	ClientSocket.receive(fSv);
	String data;
	data = (new String(fSv.getData(),0,fSv.getLength())).trim();
	System.out.println("server :"+data);
	a = inFromUser.readLine();
	b = a.getBytes();
	toSv = new DatagramPacket(b, b.length, address, port);
	ClientSocket.send(toSv);
	
	fSv = new DatagramPacket(infSv, leng1);
	ClientSocket.receive(fSv);
	data = (new String(fSv.getData(),0,fSv.getLength())).trim();
	System.out.println("server :"+data);
	
	ClientSocket.close();

}catch (UnknownHostException e)
{
	System.out.println("Server Not Found");
	System.exit(1);

}catch (IOException e)

{
	System.out.println("Cannot connect to server");	
	System.exit(1);
}
}
}