package com.company.service.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.quartz.SchedulerException;

/**
 * Created by v-leiyu on 2017/12/21.
 */
public class HelloJobListener implements JobListener {
	public static final  String LISTENER_NAMW="helloJobListener";

	@Override public String getName() {
		return LISTENER_NAMW;
	}

	@Override public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
		String name = jobExecutionContext.getJobDetail().getKey().toString();
		System.out.println(name+"将要执行");
	}

	@Override public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
		String name = jobExecutionContext.getJobDetail().getKey().getName();
		System.out.println(name+"执行被禁止");
	}

	@Override public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
		String name = jobExecutionContext.getJobDetail().getKey().getName();
		System.out.println(name+"执行完成");
//		if (!"".equals(e.getMessage())){
//			System.out.println("job:"+name+"异常："+e.getMessage());
//
//		}
	}
}
