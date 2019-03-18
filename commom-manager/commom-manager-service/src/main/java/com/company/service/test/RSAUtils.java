package com.company.service.test;

import com.alibaba.dubbo.remoting.zookeeper.ZookeeperClient;
import org.apache.commons.net.util.Base64;
import org.apache.zookeeper.ZooKeeper;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by v-leiyu on 2018/4/7.
 */
public class RSAUtils {
//	ZookeeperClient.

	public static PublicKey getPublicKey(String publicKeyStr) throws Exception {

		byte[] decode = Base64.decodeBase64(publicKeyStr);
		KeyFactory keyFactory=KeyFactory.getInstance("RSA");
		X509EncodedKeySpec x509EncodedKeySpec=new X509EncodedKeySpec(decode);
		return keyFactory.generatePublic(x509EncodedKeySpec);
	}

	public static PrivateKey getPrivateKey (String publicKeyStr) throws Exception {

		byte[] decode = Base64.decodeBase64(publicKeyStr);
		KeyFactory keyFactory=KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec=new PKCS8EncodedKeySpec(decode);
		return keyFactory.generatePrivate(pkcs8EncodedKeySpec);
	}

	public static void main(String[] args) {
		String data="MGA9HaxIE-WbH8cK0eDJGAwTPSFLgKxPEzInO0PBwVMBFcux3gijy2hDMkid3LPZL9T_4i2vSIUNXH89WPoabUuu5gBD5FOgQIyXIFjVtvjZg_leVycJhWGsQCvybSP8bdmo71HDB6Xo2NO0wqP2zy935y5v-o_P7NtYyX-Qqxk";

		String pubStr="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDCbFR1mQQxAnXtzEZIp_Lo4RVzU2c_FGCc7QoRHqBQTAxRXtn-n94ldgQBauDNm-nMu5UtsS0r-hXfaeTdJrhJ7pMZUy90kjLdvmzJ5EbjoQGoJdCzmthWBNvRD-m2tAAxYbDb0mcCpvor93RIkbkcphZudCvkG8-_xAfNmJdyZQIDAQAB";

		String zaiYao="5AC5D7632EA409612F9979B6F99D9B9A";
		try {
			PublicKey publicKey = getPublicKey(pubStr);

			Signature signature=Signature.getInstance("SHA1WithRSA");
			signature.initVerify(publicKey);

			signature.update(zaiYao.getBytes("utf-8"));

//			RSA.verify(zaiYao, data, pubStr, "utf-8");

			byte[] signdecode = Base64.decodeBase64(data);
			boolean verify = signature.verify(signdecode);
// 注意使用commons-net.jar
			System.out.println(verify);

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
