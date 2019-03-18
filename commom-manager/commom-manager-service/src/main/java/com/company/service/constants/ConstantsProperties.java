package com.company.service.constants;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by tomyu on 2018/10/9.
 */

public class ConstantsProperties {
	private static Properties properties;
	private final static String path="/properties/dataSource.properties";
	static {
		try {
			properties = PropertiesLoaderUtils.loadAllProperties(path);
		}
		catch (IOException e) {
			System.out.println("加载属性文件失败-"+path);
		}
	}

	public  static  String getPropertyByKey(String key){
		return  properties.getProperty(key);
	}
}
