package com.company.service.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by v-leiyu on 2017/12/21.
 */
public class HelloJob implements Job,Serializable {
	@Override public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("Hello Quartz!");
		long time=  System.currentTimeMillis() + 3*1000L; //3秒后启动任务
		Date statTime = new Date(time);
		System.out.println(statTime);
		Date date=new Date();
		System.out.println(date);
	//	throw new JobExecutionException("测试异常");
	}
}
