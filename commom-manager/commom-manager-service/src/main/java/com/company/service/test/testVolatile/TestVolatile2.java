package com.company.service.test.testVolatile;

import com.google.common.base.Strings;
//import org.apache.xpath.SourceTree;

import java.util.Dictionary;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Created by tomyu on 2018/9/29.
 */

// Volatile 常用用法2  标记状态量。  一个线程操作状态量，其他线程读取

public class TestVolatile2 {

	private volatile  static boolean flg=true;

	public static void main(String[] args) {

		final  CountDownLatch countDownLatch=new CountDownLatch(2);

		Thread thread1=new Thread(new Runnable() {
			@Override public void run() {
				System.out.println("第一个线程死劲循环");
				countDownLatch.countDown();
				while (flg){

				}
				System.out.println(System.currentTimeMillis());
				System.out.println("结束循环");
			}
		});
		thread1.start();

		Thread thread2=new Thread(new Runnable() {
			@Override public void run() {
				System.out.println("第er个线程控制循环");
				countDownLatch.countDown();
				System.out.println("等你输入控制：");
				Scanner scanner=new Scanner(System.in);
				String next = scanner.next();
				if (!Strings.isNullOrEmpty(next)){
					flg=false;
					System.out.println(System.currentTimeMillis());
				}

				System.out.println("结束控制");
			}
		});
		thread2.start();
		System.out.println("大家开始");
	}

}
