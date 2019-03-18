package com.company.service.test;

import java.util.regex.Pattern;

/**
 * Created by tomyu on 2018/8/30.
 */
public class TestReg {
	public static void main(String[] args) {
		boolean matches = Pattern.matches("^bjjxq(-\\w{1,6}){4}\\.psvp-pay-\\w{3,7}(\\.\\w{2,6}){4}$-stop", "bjjxq-b-tomcat-188-116.psvp-pay-sub.lin.idc.pplive.cn");
		System.out.println(matches);
	}
}
