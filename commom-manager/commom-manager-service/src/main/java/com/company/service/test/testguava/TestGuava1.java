package com.company.service.test.testguava;

import com.google.common.base.Optional;

/**
 * Created by tomyu on 2018/11/1.
 */
public class TestGuava1 {
	public static void main(String args[]){
		TestGuava1 guavaTester = new TestGuava1();

		Integer a=null;
		Optional<Integer> o1=Optional.of(a);
		Optional<Integer> o2=Optional.of(new Integer(2));
		Integer sum = guavaTester.sum(o1, o2);
		System.out.println(sum);


	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b){
		return a.get() + b.get();
	}

}
