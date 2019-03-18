package com.company.service.test.testExtent;

/**
 * Created by tomyu on 2018/11/1.
 */
public class TestMai {
	public static void main(String[] args) {
		GeZi geZi1=new GeZi();
		Bird geZi2=new GeZi();
		System.out.println("判断子类是父类的继承"+(geZi1 instanceof Bird)); //true
		System.out.println("判断父类是父类自己"+(geZi2 instanceof Bird));//true
		System.out.println("判断父类是子类"+(geZi2 instanceof GeZi));//true

	}
}
