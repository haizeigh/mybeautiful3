package com.company.service.test.testJframe;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by tomyu on 2018/9/30.
 */
public class TestMouse {
	public static void main(String[] args) throws InterruptedException {
		while (true){
			PointerInfo pointerInfo = MouseInfo.getPointerInfo();
			Point location = pointerInfo.getLocation();
			Scanner scanner=new Scanner(System.in);
			Thread.sleep(500);
//			System.out.println("输入任意开始");
//			String next = scanner.next();
			System.out.println(location.getX()+"____"+location.getY());
//			System.out.println();
//			if (next.equals("stop")){
//				break;
//			}
		}

	}
}
