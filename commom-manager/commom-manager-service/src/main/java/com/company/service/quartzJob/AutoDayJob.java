package com.company.service.quartzJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by v-leiyu on 2017/12/28.
 */

public class AutoDayJob implements Job {

	public  void sendEmail(){

	}

	@Override public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("计划手动触发发送邮件");
	}


}
