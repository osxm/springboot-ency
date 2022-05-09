/**  
* @Title: KeyStoreTests.java
* @Package com.osxm.springbootency.security
* @Description: TODO
* @author XM
* @date 2022年3月19日 上午9:34:32
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.springbootency.security;

import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.Base64;
import java.util.Enumeration;

import org.junit.jupiter.api.Test;

public class KeyStoreTests {

	@Test
	public void readKeyStore() throws Exception {
		String keyStoreFilePath = "D:\\work\\writting\\book\\security\\my.keystore";
		String keyStorePass = "111111";
		String keyPass = "111111";
		FileInputStream fis = new FileInputStream(new File(keyStoreFilePath));
		KeyStore keystore = KeyStore.getInstance("JKS");
		keystore.load(fis, keyStorePass.toCharArray());

		// 遍历密钥库中的条目
		Enumeration<String> aliaes = keystore.aliases();
		while (aliaes.hasMoreElements()) {
			String alias = aliaes.nextElement();
			// 私钥
			Key key = keystore.getKey(alias, keyPass.toCharArray());
			System.out.println("私钥：");
			System.out.println(Base64.getEncoder().encodeToString(key.getEncoded()));

			// 证书： 包含公钥
			Certificate[] certs = keystore.getCertificateChain(alias);
			for (Certificate cert : certs) {
				PublicKey puk = cert.getPublicKey();
				System.out.println("公钥：");
				System.out.println(puk);
			}
		}
	}

	// if(key!=null && key instanceof PrivateKey) {
	// RSAPrivateCrtKey rik = (RSAPrivateCrtKey)key;
	// System.out.println(new String(key.getEncoded()));
	// System.out.println(Base64.getEncoder().encodeToString(key.getEncoded()));
	// }
}
