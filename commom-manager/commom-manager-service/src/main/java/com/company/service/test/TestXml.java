package com.company.service.test;

import com.company.utils.XmlReaders;

/**
 * Created by tomyu on 2018/7/8.
 */
public class TestXml {
	public static void main(String[] args) {
//		String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<xml>\n" + "<name>yulei</name>\n" + "</xml>";
//		String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<xml>\n" + "<name>yulei</name>\n" + "</xml>";
		String xml="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" + "<!DOCTYPE root [\n"
				+ "  <!ENTITY myentity \"testting\">  \n" + "]>\n" + "<xml>\n" + "<name>&myentity;</name>\n" + "</xml>";
		xml=xml.replaceAll("(\\r|\\n)","");
		System.out.println("要解析的xml是"+xml);
		XmlReaders xmlReaders = XmlReaders.create(xml);
		String name = xmlReaders.getNodeStr("name");
		System.out.println("解析的结果是"+name);
	}
}
