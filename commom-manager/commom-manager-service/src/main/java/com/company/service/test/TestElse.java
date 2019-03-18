package com.company.service.test;

import java.io.UnsupportedEncodingException;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by tomyu on 2018/7/13.
 */
public class TestElse {
	public static void main(String[] args) {
		int[] a;
		a=new int[4];
		//初始化时才使用简化的静态初始化方法
		int[] b={1,2,3};


		System.out.println(	);
		System.out.println(Integer.MAX_VALUE);

		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("ddHHmmssSSS");
		String prefix = simpleDateFormat.format(new Date());
		Random random=new Random();
		int subfix = random.nextInt(1000);
		System.out.println(prefix+subfix);

		String word="PPTV鍚庡彴鐧诲綍绯荤粺";

		try {
			String string = new String(word.getBytes("iso8859-1"), "utf-8");
			System.out.println(string);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
}
