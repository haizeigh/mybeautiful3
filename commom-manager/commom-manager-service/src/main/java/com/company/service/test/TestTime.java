package com.company.service.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by v-leiyu on 2018/2/11.
 */
public class TestTime {
	public static void main(String[] args) {

		try {
			getLong("2018-02-10 17:30:00");
			getLong("2018-02-10 17:31:00");
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public  static  void getLong(String time) throws ParseException {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse = simpleDateFormat.parse(time);
		System.out.println(parse.getTime());
	}

	@Test
	public void testCalan(){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println(calendar.getTime());
		//HOUR_OF_DAY 24小时制
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		//HOUR_OF_DAY 12小时制
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		System.out.println(calendar.getTime());
	}
}
