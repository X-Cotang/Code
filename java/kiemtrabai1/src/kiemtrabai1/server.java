package kiemtrabai1;


import java.net.*;

import java.io.*;

public class server {

public static void main(String args[ ]) throws IOException{

	ServerSocket server = new ServerSocket(1002);
	System.out.println("Server cho o cong 1000");
	Socket client = server.accept();
	DataInputStream in = new DataInputStream(client.getInputStream());
	DataOutputStream out = new DataOutputStream(client.getOutputStream());
	String o = null;
	String inLine = in.readLine();
	String inLine2=in.readLine();
	if(isNumeric(inLine)&&isNumeric(inLine2)) {
		int a=Integer.parseInt(inLine);
		int b=Integer.parseInt(inLine2);
		if(ktra(b)==true&&ktra(a)==true) {
			if(a>b) {
				o=a+ " lon hon "+b;
				out.writeBytes(o);
				out.write(13);
				out.write(10);
			}else if(a<b) {
				o=a+ " nho hon "+b;
				out.writeBytes(o);
				out.write(13);
				out.write(10);
			}else if(a==b){
				o=a+ " bang "+b;
				out.writeBytes(o);
				out.write(13);
				out.write(10);
			}
			out.write(13);
			out.write(10);
		}else {
			if(ktra(a)==true) {
				out.writeBytes(a+" la so nguyen to!");
				out.write(13);
				out.write(10);
			}else {
				out.writeBytes(a+" khong la so nguyen to!");
				out.write(13);
				out.write(10);	
			}
			if(ktra(b)==true) {
				out.writeBytes(b+" la so nguyen to!");
				out.write(13);
				out.write(10);
			}else {
				out.writeBytes(b+" khong la so nguyen to!");
				out.write(13);
				out.write(10);	
			}
		}
	}else {
		out.writeBytes("Loi !!!");
		out.write(13);
		out.write(10);	
		out.writeBytes(inLine+" va "+inLine2+" khong la so nguyen hoac nho hon khong");
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
public static boolean isNumeric(String str) { 
	  try {  
	    int a=Integer.parseInt(str);
	    if(a>0) {
	    	return true;
	    }else {
	    	return false;
	    }
	  } catch(NumberFormatException e){  
	    return false;  
	  }  
}
}
