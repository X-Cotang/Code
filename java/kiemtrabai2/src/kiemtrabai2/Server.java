package kiemtrabai2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;



/**
 *
 * @author tutq9
 */
public class Server {
    
    static ListTaiKhoan list = new ListTaiKhoan();
    public static void init() throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader("./db.dat");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine())!=null)
        {
            String tmp[] = line.split("\\$");
            TaiKhoan tk = new TaiKhoan(tmp[0], tmp[1], tmp[2], tmp[3], Integer.parseInt(tmp[4]), tmp[5]);
            list.ThemTK(tk);
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        int port = 1234;
              
        init();

        try {
            
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("[+] Server ");

            byte[] in = new byte[1024];
            DatagramPacket pkt ;
            String data;
            String cSTK;
            
            
            while(true)
            {
                pkt = new DatagramPacket(in,in.length);   
                socket.receive(pkt);
                data = new String(pkt.getData(),0,pkt.getLength());
                cSTK = list.DangNhap(data);
                int sPort = pkt.getPort();
                InetAddress address = pkt.getAddress();
                
                if(cSTK.equals(""))
                {
                    data = "That bai";
                    pkt = new DatagramPacket(data.getBytes(),data.getBytes().length,address,sPort);
                    socket.send(pkt);
                    continue;
                }
                
                data = "Dang nhap thanh cong";
                pkt = new DatagramPacket(data.getBytes(),data.getBytes().length,address,sPort);
                socket.send(pkt);
                
                pkt = new DatagramPacket(in,in.length);   
                socket.receive(pkt);
                
                data = new String(pkt.getData(),0,pkt.getLength());
                
                
                if(data.equals("1"))
                {
                    socket.receive(pkt);
                    String tmp1 = new String(pkt.getData(),0,pkt.getLength());
                    socket.receive(pkt);
                    String tmp2 = new String(pkt.getData(),0,pkt.getLength());
                    
                    if (list.ChuyenTien(cSTK, tmp1, Integer.parseInt(tmp2)))
                        data = "Done";
                    else 
                        data = "Loi";
                    pkt = new DatagramPacket(data.getBytes(),data.getBytes().length,address,sPort);
                    socket.send(pkt);
                }
                else if(data.equals("2"))
                {
                    socket.receive(pkt);
                    String tmp1 = new String(pkt.getData(),0,pkt.getLength());
                    if (list.ruttien(cSTK,Integer.parseInt(tmp1)))
                        data = "Done";
                    else 
                        data = "Loi";
                    pkt = new DatagramPacket(data.getBytes(),data.getBytes().length,address,sPort);
                    socket.send(pkt);
                }
                else if(data.equals("3"))
                {
                    data = String.valueOf(list.getSodu(cSTK));
                    pkt = new DatagramPacket(data.getBytes(),data.getBytes().length,address,sPort);
                    socket.send(pkt);
                }
                else if(data.equals("4"))
                {
                    data = list.getLSGD(cSTK);
                    pkt = new DatagramPacket(data.getBytes(),data.getBytes().length,address,sPort);
                    socket.send(pkt);
                }
                
                list.update();
                
                               
            }
        } catch (SocketException e) {
            System.out.println("[!]");
        } catch (Exception q){
            q.printStackTrace();
        }
    }
}
