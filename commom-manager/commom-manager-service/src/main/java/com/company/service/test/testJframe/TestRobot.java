package com.company.service.test.testJframe;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by tomyu on 2018/9/30.
 */
public class TestRobot {
	public static void main(String[] args) throws AWTException, IOException {
		Robot robot=new Robot();
		//每个操作完成后自动延时ms
		robot.setAutoDelay(2000);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screenSize.getSize());
		//截屏的操作
		Rectangle rectangle=new Rectangle(screenSize);
		BufferedImage screenCapture = robot.createScreenCapture(rectangle);
		File file=new File("e:/test.png");
		ImageIO.write(screenCapture,"png",file);

		System.out.println("开始机器人");
		//移动鼠标
		robot.mouseMove(500,10);

		//点击鼠标右键
		System.out.println("点击右键");
		robot.mousePress(InputEvent.BUTTON3_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_MASK);

		//鼠标左键
		/*System.out.println("点击坐键");
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
*/
		//按下键盘esc键
		System.out.println("按下键盘esc键");
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

		System.out.println("移动鼠标");
		robot.mouseMove(800,400);
		System.out.println("点击坐键");
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);

		//滚动鼠标滚轴
		System.out.println("滚轴");
		robot.mouseWheel(-25);

//		alt tab 组合按键
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_ALT);


	}
}
