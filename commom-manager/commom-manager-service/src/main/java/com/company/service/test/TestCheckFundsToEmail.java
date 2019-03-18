package com.company.service.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by tomyu on 2018/10/16.
 */
public class TestCheckFundsToEmail {
	private final String  toEmial="haizeiwy@163.com";
	private final String fromEmail="1254126426@qq.com";

	private final String PWD_OF_FROM_EMAIL="uturvjbwkidhggga";

	private String host = "smtp.qq.com";


	public String searchinCreamentRate(String url){
		Document document=null;
		try {
			 document = Jsoup.connect(url).userAgent("").get();
		}
		catch (IOException e) {
			System.out.println("连接失败："+url);
		}
		//#main > div > div.fund-essential > div.fund-essential_toolbox > div.fund-essential_return > span.num > small > span
		//#main > div > div.fund-essential > div.fund-essential_toolbox > div.fund-essential_return > span.num > small > span
		Elements increasement = document.select("#main").select("div").select("div.fund-essential")
				.select("div.fund-essential_toolbox").select("div.fund-essential_return").select("span.num")
				.select("small").select("span");
		String increasementStr = increasement.text().replace("%","");
		return  increasementStr;
	}

	public void sendEmail(String growthRate){
		Properties properties = System.getProperties();
		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");

		Session defaultInstance = Session.getDefaultInstance(properties, new Authenticator() {
			@Override protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, PWD_OF_FROM_EMAIL);
			}
		});
		try {
			MimeMessage mimeMessage=new MimeMessage(defaultInstance);
			mimeMessage.setFrom(new InternetAddress(fromEmail));
			mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmial));

			mimeMessage.setSubject("幅度过大");
			mimeMessage.setText("目前幅度是："+growthRate);

			Transport.send(mimeMessage);
		}
		catch (MessagingException e) {
			System.out.println("发送邮件失败");
		}
		System.out.println("发送邮件成功");
	}

	public static void main(String[] args) {
		TestCheckFundsToEmail checkFundsToEmail=new TestCheckFundsToEmail();
		String s = checkFundsToEmail.searchinCreamentRate("http://www.bosera.com/fund/159937.html");
		String replace = s.replace("-", "");
		double price = Double.parseDouble(replace);
		if (price>0.9){
			checkFundsToEmail.sendEmail(s);
		}

	}


}
