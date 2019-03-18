package com.company.service.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tomyu on 2018/11/12.
 */
public class TestSHA1Digest {

	String baseStr="0123456789abcdef";

	public String testSHA1Digest(String originalStr) throws Exception {
		//创建加密器
		MessageDigest messageDigest=MessageDigest.getInstance("SHA1");
		messageDigest.update(originalStr.getBytes("UTF-8"));

		//获得加密摘要
		byte[] digest = messageDigest.digest();
		int digestLength = digest.length;
		char[] chars = baseStr.toCharArray();
		char[] digestchars =new char[digestLength*2];
		for (int i=0,k=0;i<digestLength;i++){
			byte digestByte=  digest[i];
			// >>>:无符号右移
			// &:按位与
			//0xf:0-15的数字
			digestchars[k++] = chars[digestByte >>> 4 & 0xf];
			if ((digestByte & 0xf)>=chars.length){
				System.out.println();
			}
			digestchars[k++] = chars[digestByte & 0xf];
		}
		//字符数组转为字符串
		return new String(digestchars);
	}

	public static void main(String[] args) throws Exception {
		TestSHA1Digest testSHA1Digest=new TestSHA1Digest();
		System.out.println(testSHA1Digest.testSHA1Digest("ceshi"));
	}
}
