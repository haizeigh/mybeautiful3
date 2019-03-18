package com.company.service.test;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by tomyu on 2018/10/26.
 */
public class TestExecption {
	public static void main(String[] args) {
		try {
			TestExecption testExecption=new TestExecption();
			testExecption.testerr();
		}
		catch (Exception e) {
			//以String形式获取Exception的详细信息
			StringWriter stringWriter=new StringWriter();
			PrintWriter printWriter=new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			System.out.println(stringWriter.toString());
		}
	}

	public void  testerr(){
		System.out.println("开始");
		System.out.println("下面出现异常");
		System.out.println(1/0);
		System.out.println("结束");
	}
}
