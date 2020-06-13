package kiemtrabai1;
import java.net.*;
import java.io.*;
public class client {
public static void main(String args[ ]) throws Exception
{

	Socket client= new Socket("127.0.0.1",1002);
	System.out.println("Ket noi toi Server cong 1000.");
	DataInputStream in = new DataInputStream(client.getInputStream());
	DataOutputStream out = new DataOutputStream(client.getOutputStream());
	BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	int i;
	String sendLine=null;
	System.out.print("Nhap so thu nhat: ");
	sendLine = buf.readLine();
	out.writeBytes(sendLine);
	out.write(13);
	out.write(10);
	sendLine=null;
	System.out.print("Nhap so thu hai: ");
	sendLine = buf.readLine();

	out.writeBytes(sendLine);
	out.write(13);
	out.write(10);
	
	String inLine = in.readLine();
	System.out.println(inLine);

	inLine = in.readLine();
	System.out.println(inLine);

	
	in.close();
	out.close();
	client.close();
}


}