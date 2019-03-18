package com.company.web.utils;

import com.company.web.controller.IndexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by tomyu on 2019/1/24.
 */
public class Constants {
	private static Properties properties;
	private static Logger logger= LoggerFactory.getLogger(Constants.class);
	static {
		InputStream resourceAsStream =null;
		try {

			 resourceAsStream = Constants.class.getResourceAsStream("/properties/url.properties");
			properties=new Properties();
			properties.load(resourceAsStream);
			logger.info("加载配置文件成功");
		}
		catch (IOException e) {
			logger.info("加载配置文件失败",e);
		}finally {
			if (resourceAsStream!=null){
				try {
					resourceAsStream.close();
				}
				catch (IOException e) {
					logger.info("关闭流失败",e);
				}
			}
		}
	}

	public static String getProperty(String key){
		return  properties.getProperty(key);
	}

}
