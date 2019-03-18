package com.company.service.test;

/**
 * Created by tomyu on 2018/12/26.
 */
public class TestInteger {
	public static void main(String[] args) {
		MyInt myInt=new MyInt();
		System.out.println(myInt.getA());
		System.out.println(0==myInt.getA());
	}
}

class MyInt{
	private  Integer a;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}
}
