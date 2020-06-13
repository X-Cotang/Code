package test;

import java.net.*;

import java.io.*;

public class server {

public static void main(String args[ ]) throws IOException{

	ServerSocket server = new ServerSocket(1000);
	System.out.println("Server cho o cong 1000");
	Socket client = server.accept();
	DataInputStream in = new DataInputStream(client.getInputStream());
	DataOutputStream out = new DataOutputStream(client.getOutputStream());
	//String pass="xinchao";
	String inLine = in.readLine();
	/*int dem=0;
	while(dem!=3) {
		if(inLine.equals(pass)) {
			out.writeBytes("correct");
			out.write(13);
			out.write(10);
			break;
		}else {
			out.writeBytes("incorrect");
			out.write(13);
			out.write(10);
			dem++;
			if(dem==3) {
				out.writeBytes("Nhap sai qua 3 lan!!");
				out.write(13);
				out.write(10);
			}else {
			inLine=in.readLine();
			}
		}
	}
	*/
	int a=Integer.parseInt(inLine);
	
	//String outLine = inLine.toUpperCase();
	
//	out.writeBytes(outLine);
	
//	out.write(13);
	
	//out.write(10);
	if(ktra(a)==true) {
		out.writeBytes(inLine+" la so nguyen to!");
		out.write(13);
		out.write(10);
	}else {
		out.writeBytes(inLine+" khong la so nguyen to!");
		out.write(13);
		out.write(10);
	}
	in.close();
	
	out.close();
	
	client.close();
	server.close();
}
public static boolean ktra(int n) {
    if (n < 2) {
        return false;
    }
    int a = (int) Math.sqrt(n);
    for (int i = 2; i <= a; i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}
}
