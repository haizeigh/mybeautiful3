package com.company.service.test;

import java.util.regex.Pattern;

/**
 * @author yl
 * @date 2019-08-26
 */
public class TestDateReg {

    public static void main(String[] args) {
        String reg="^20\\d{2}-(0[1-9]|[1][0-2])-([0][1-9]|[1-2][0-9]|[3][1]) (0[1-9]|[1][0-9]|[2][0-3]):[0-5]\\d:[0-5]\\d\\.\\d{3}$";
        boolean matches = Pattern.matches(reg, "2019-08-22 10:54:10.999");
        System.out.println(matches);
    }
}
