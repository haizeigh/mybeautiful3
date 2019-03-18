package com.company.service.test;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tomyu on 2018/10/18.
 */
public class TestLog {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(TestLog.class);
		org.slf4j.Logger logger1 = LoggerFactory.getLogger(TestLog.class);
		logger1.info("没有在流水表归档表中得到结果：要查的流水号[{}],交易号[{}]，payWay[{   }]，查找的表有[{}]","1","2","3","4");

	}
}
