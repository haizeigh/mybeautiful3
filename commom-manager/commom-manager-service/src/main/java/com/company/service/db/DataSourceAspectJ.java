package com.company.service.db;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by v-leiyu on 2018/4/18.
 */
@Aspect
@Component
public class DataSourceAspectJ {

	{
		Logger logger = Logger.getLogger(DataSourceAspectJ.class);
		logger.debug("测试log4j的debug级别");
		logger.info("测试log4j的info级别");
		System.out.println("实例化切面注解");
	}
	//注解里面的参数 首字母小写.因为 参数里面已经申明类型
	@Around(value = "@annotation(dataSelecter)")
	public Object DataSelecterAspect(ProceedingJoinPoint proceedingJoinPoint,DataSelecter dataSelecter){

		try {
			DataSourceHolder.setDataKey(dataSelecter.dateType().getKey());
			System.out.println("目前的数据类型是"+dataSelecter.dateType().getDesc());
			return  proceedingJoinPoint.proceed();
		}
		catch (Throwable throwable) {
			throw  new RuntimeException("数据库选择出错");
		}finally {
			DataSourceHolder.deleteDataKey();
		}
	}

	/*@After(value = "@annotation(DataSelecter)")
	public void deleteDataSourceCache(){
		System.out.println("目前数据库key的缓存是"+DataSourceHolder.getDataKey()+"，现在开始删除");
		DataSourceHolder.deleteDataKey();
	}*/
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(DataSourceAspectJ.class);
		logger.debug("测试log4j的debug级别");
	}
}
