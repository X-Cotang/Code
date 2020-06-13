package rmi;

import java.io.FileInputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class decrypt {

	public static void main(String[] args) {
		try {
		
			FileInputStream fis = new FileInputStream("./privateKey.rsa");
			byte[] b = new byte[fis.available()];
			fis.read(b);
			fis.close();

			
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b);
			KeyFactory factory = KeyFactory.getInstance("RSA");
			PrivateKey priKey = factory.generatePrivate(spec);

			
			Cipher c = Cipher.getInstance("RSA");
			c.init(Cipher.DECRYPT_MODE, priKey);
			byte decryptOut[] = c.doFinal(Base64.getDecoder().decode(
					"e7ytIbpwZ1fi6FVKyJfNcMYgaq/lmYUubGVLEml2bvkN/q2m82yrIAiTyGoKx1mWbNmP4pbr7Q66dAYHdQDqRr1ibtl/HvzVcmk2fYNpH8gezx4XVSXMnhaSlDUntwOkEAdPjL31PqyYkImBglvXrMue/wirVYfsyLjHnuSGH58="));
			System.out.println("cc: " + new String(decryptOut));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}