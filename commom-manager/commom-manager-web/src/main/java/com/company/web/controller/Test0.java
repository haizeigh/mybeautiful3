package com.company.web.controller;

import com.company.web.utils.Constants;

/**
 * Created by v-leiyu on 2017/12/29.
 */
public class Test0   {
	public static void main(String[] args) {
		System.out.println(0);
		String url1 = Constants.getProperty("testUrl");
		System.out.println("配置文件值"+url1);
	}

}
