

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class client {
    static DatagramSocket socket;
    static DatagramPacket packet;
	public static void main(String[] args) throws SocketException {
		socket = new DatagramSocket();
		String creden=null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap tai khoan: ");
		creden=sc.nextLine();
		System.out.println("Nhap mat khau: ");
		creden+="&"+sc.nextLine();
		//System.out.println(creden);
		gui(creden);
		if(nhan().equals("Dang nhap that bai")) {
			System.out.println("Dang nhap that bai");
			System.exit(0);
		}
		String tien=null;
		int k=-1;
		while (k!=5) {            
            System.out.println("-----------------MENU-----------------------");
            System.out.println("1. Rut tien");
            System.out.println("2. Gui tien");
            System.out.println("3. Xem so du");
            System.out.println("4. Xem lich su thu/chi");
            System.out.println("5. Ket thuc");
            System.out.print("Ban chon: ");
       
            k = Integer.parseInt(sc.nextLine());
           
                if(k==1) {
                    System.out.print("Nhap so tien: ");
                    gui("mot");
                    tien = sc.nextLine();
                    gui(tien);
                    System.out.println("So du: "+nhan());
                    sc.nextLine();
                    k=0;
                    continue;}
                else if(k==2) {
                    System.out.print("Moi ban nhap tien: ");
                    gui("hai");
                    tien = sc.nextLine();
                    gui(tien);
                    System.out.println("So du: "+nhan());
                    sc.nextLine();
                    k=0;
                    continue;}
                else if(k==3) {
                	gui("ba");
                    System.out.println("So du tai khoan la: "+nhan());
                    sc.nextLine();
                    k=0;
                    continue;}
                else if(k==4) {
                	gui("bon");
                	System.out.println(nhan());
                	k=0;
                    continue;
                }
                else if(k==5) {
                	System.exit(0);
                	k=0;
                    continue;
                }
                    
             
            }
            }
		
		
	
	
    public static void gui(String s) {
        try {
            byte[] data = new byte[1024];
            data = s.getBytes();
            InetAddress ip = InetAddress.getByName("localhost");
            packet = new DatagramPacket(data, data.length, ip, 1244);
            socket.send(packet);
        } catch (IOException ex) {
            
        }
    }

    public static String nhan() {
        try {
            byte[] data = new byte[1024];
            packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String s = new String(packet.getData()).trim();
            System.out.println(s);
            return s;
        } catch (IOException ex) {
            return "";
        }
    }
}
