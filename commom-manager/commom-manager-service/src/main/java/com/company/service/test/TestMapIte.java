package com.company.service.test;

import org.junit.Test;

import java.util.*;

/**
 * Created by v-leiyu on 2018/2/24.
 */
public class TestMapIte {
	public static void main(String[] args) {
		Map<String,String> map=new HashMap();
		map.put("a","12");
		setTest(map);
		System.out.println(map.get("v")+"aa");
	}
	public static void it(Map<String,String> map){
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()){
			String next = iterator.next();
		}
	}

	@Test
	public void timeTest(){
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,5);
		System.out.println(calendar.getTime());
		System.out.println(calendar.getTimeInMillis());

	}
	@Test
	public static void setTest(Map<String,String> ftpMap){
		Set<String> set = ftpMap.keySet();
		HashSet<String> newKeySet= new HashSet<>();
		newKeySet.addAll(set);

		System.out.println(set);
		System.out.println(newKeySet);

		newKeySet.remove("a");
		try {
			set.add("a");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(set);
		System.out.println(newKeySet);
	}

}
