package com.company.service.test.testVolatile;

import java.util.concurrent.CountDownLatch;

/**
 * Created by tomyu on 2018/9/29.
 */

// volatile 的常用应用场景 double check 产生的单例模式
public class TestVolatile1 {

	private TestVolatile1(){}
	{
		System.out.println("产生一个单例");
	}
	private volatile  static TestVolatile1 testVolatile1;

	public static TestVolatile1 getInstance(){

		if (testVolatile1==null){
			synchronized (TestVolatile1.class){
				if (testVolatile1==null){
					testVolatile1=new TestVolatile1();
				}
			}
		}
		return testVolatile1;
	}

	public static void main(String[] args) {
		final  CountDownLatch countDownLatch=new CountDownLatch(100);

		for (int i=0;i<100;i++){
			Thread thread=new Thread(new Runnable() {
				@Override public void run() {
					System.out.println("我开始了");
					TestVolatile1.getInstance();
					countDownLatch.countDown();

				}
			});
			thread.start();
		}
		System.out.println("全部开始");
	}
}
