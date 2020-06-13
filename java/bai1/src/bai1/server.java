package bai1;
import java.net.*;
import java.io.*;

class server {

    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3335);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";
        while (!str.equals("stop")) {
            str = din.readUTF();
            System.out.println("client says: " + str);
            switch (str) {
                case "dantri.com":
                    str2="222.255.27.51";
                    break;
                case "24h.com.vn":
                    str2="125.212.247.65";
                    break;
                case "vnexpress.net":
                    str2="111.65.250.2";
                        break;
            }
            dout.writeUTF(str2);
            dout.flush();
        }
        din.close();
        s.close();
        ss.close();
    }
    
}