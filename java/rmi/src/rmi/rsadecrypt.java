package rmi;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class rsadecrypt {

	public static void main(String[] args) {
		try {
		
			FileInputStream fis = new FileInputStream("./publicKey.rsa");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fis.close();

						X509EncodedKeySpec spec = new X509EncodedKeySpec(b);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			PublicKey pubKey = factory.generatePublic(spec);

			
			Cipher c = Cipher.getInstance("RSA");
			c.init(Cipher.ENCRYPT_MODE, pubKey);
			String msg = "helloworld";
			byte encryptOut[] = c.doFinal(msg.getBytes());
			String strEncrypt = Base64.getEncoder().encodeToString(encryptOut);
			System.out.println("chuoi ma hoa: " + strEncrypt);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}