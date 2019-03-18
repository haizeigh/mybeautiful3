package com.company.service.test;

import com.company.service.test.model.PayAgreementInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomyu on 2018/9/18.
 */
public class TestListSize {
	public static void main(String[] args) {
		PayAgreementInfo payAgreementInfo=new PayAgreementInfo();
		List<PayAgreementInfo> list =new ArrayList<>();
		for (int i=0;i<610000;i++){
			list.add(new PayAgreementInfo());
		}

		for (;;){
			try {
				Thread.sleep(30000);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			List list1=new ArrayList();
			list1=list;
			System.out.println(1233);
		}

	}

	@Test
	public void test(){
		int a=1 ,b=1;
		System.out.println(a++);
		System.out.println(++b);

		String x="abc";
		System.out.println(x.substring(0,0));
	}
}
