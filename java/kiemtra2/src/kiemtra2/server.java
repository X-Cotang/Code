
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class server {
	public static ArrayList<taikhoan> listTk;
	public static void main(String[] args) throws IOException {
		int port = 1244;
		String tk;
		String mk;
		int sodu;
		String hoten;
		String stk;
		ArrayList<String> ls=new ArrayList<String>();
		File fv=new File("./data");
		String line;
		listTk=new ArrayList<taikhoan>();
		FileInputStream f1=new FileInputStream(fv);
		InputStreamReader f2=new InputStreamReader(f1, "UTF-8");
		BufferedReader br = new BufferedReader(f2);
		
		while ((line = br.readLine()) != null){
			  //System.out.println(line.hashCode());
			  tk=br.readLine();
			  mk=br.readLine();
			  hoten=br.readLine();
			  stk=br.readLine();
			  sodu=Integer.parseInt(br.readLine());
			  System.out.println(sodu);
			  listTk.add(new taikhoan(tk, mk, sodu, hoten, stk));
			}
		
		
		DatagramSocket socket = new DatagramSocket(port);
        System.out.println("[+] Server ");

        byte[] in = new byte[1024];
        DatagramPacket pkt ;
        String data;
        pkt = new DatagramPacket(in,in.length);   
        socket.receive(pkt);
        data = new String(pkt.getData(),0,pkt.getLength());
        
        int sPort = pkt.getPort();
        InetAddress address = pkt.getAddress();
        int nho=dangNhap(data);
        if(nho==-1) {
        	data="Dang nhap that bai";
        	in=data.getBytes();
        	pkt = new DatagramPacket(in,in.length,address,sPort);
            socket.send(pkt);
            System.exit(0);;
            
        	
        }else {
        	data = "Dang nhap thanh cong";
        	in=data.getBytes();
        	pkt = new DatagramPacket(in,in.length,address,sPort);
            socket.send(pkt);
        }
       while(true) {
            try {
           
            pkt = new DatagramPacket(in,in.length);   
            socket.receive(pkt);
            data = new String(pkt.getData(),0,pkt.getLength());
            System.out.println(data);
            if(data.equals("mot")) {
            
            	
            	pkt = new DatagramPacket(in,in.length);   
                socket.receive(pkt);
                data = new String(pkt.getData(),0,pkt.getLength());
                System.out.println(data);
                int tien=Integer.parseInt(data);
                ls.add("Rut: "+Integer.toString(tien));
                int sodu1=listTk.get(nho).getSodu()-tien;
                listTk.get(nho).setSodu(sodu1);
                data = Integer.toString(listTk.get(nho).getSodu());
                pkt = new DatagramPacket(data.getBytes(),data.getBytes().length,address,sPort);
                socket.send(pkt);
                
            }
            else if(data.equals("hai")) {
            	pkt = new DatagramPacket(in,in.length);   
                socket.receive(pkt);
                data = new String(pkt.getData(),0,pkt.getLength());
                int tien=Integer.parseInt(data);
                ls.add("Nap tien: "+Integer.toString(tien));
                int sodu1=listTk.get(nho).getSodu()+tien;
                listTk.get(nho).setSodu(sodu1);
                data = Integer.toString(listTk.get(nho).getSodu());
                pkt = new DatagramPacket(data.getBytes(),data.getBytes().length,address,sPort);
                socket.send(pkt);
            }
            else if(data.equals("ba")) {
            	data = Integer.toString(listTk.get(nho).getSodu());
                pkt = new DatagramPacket(data.getBytes(),data.getBytes().length,address,sPort);
                socket.send(pkt);
            }else if(data.equals("bon")) {
            	String c="";
            	for(String s:ls) {
            		c+=s+"\n";
            	}
            	data=c;
            	pkt = new DatagramPacket(data.getBytes(),data.getBytes().length,address,sPort);
                socket.send(pkt);
            }
            data="";
            
            }catch (Exception e) {
				// TODO: handle exception
            	System.out.print(e);
			}
       }
	}
	public static int dangNhap(String data) {
		int a=0;
		for(taikhoan tk1:listTk) {
        	String creden=tk1.getTk()+"&"+tk1.getMk();
        	if(data.equals(creden)) {
        		return a;
        	}
        	a++;
        }
		return -1;
	}
}
