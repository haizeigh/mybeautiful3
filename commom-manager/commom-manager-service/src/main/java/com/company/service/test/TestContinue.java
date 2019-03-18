package com.company.service.test;

import org.junit.Test;

import java.util.Date;

/**
 * Created by tomyu on 2018/9/20.
 */
public class TestContinue {
	public static void main(String[] args) {
		for(int j = 0 ; j<3 ; j++){ // j=0 外层for循环
			boolean nextPage=true;
			int pageNum = 1;
			for(int i = 0 ; i< 2 ; i++){  // i=0 内层for循环
				System.out.println("hello world"); // 1
				 nextPage=false;
				 pageNum = 3;
				continue;
			}
//break 跳出内循环 ，也就是执行次数就是外循环次数
//continue 继续内循环 ，也就是执行次数就是外循环次数*内循环次数

		}
	}

	@Test
	public void  testTime(){
		Date date1=new Date("");
		System.out.println(date1);
		Date date2=new Date(1537435247);

		System.out.println(date1.before(date2));

	}
}
