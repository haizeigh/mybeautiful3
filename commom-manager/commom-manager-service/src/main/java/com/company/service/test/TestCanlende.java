package com.company.service.test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by tomyu on 2018/8/27.
 */
public class TestCanlende {
	public static void main(String[] args) {
		Date date=new Date("2018/01/31");
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
//		1.31号 加 30天，是3.2
//		calendar.add(Calendar.DAY_OF_MONTH,30);
		//		1.31号 加 1 月，是2.28
		calendar.add(Calendar.MONTH,1);
		System.out.println(calendar.getTime());


	}
}
