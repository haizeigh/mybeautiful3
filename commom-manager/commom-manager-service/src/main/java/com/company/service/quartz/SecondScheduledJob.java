package com.company.service.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * Created by v-leiyu on 2017/12/21.
 */
@Component("secondScheduledJob")
public class SecondScheduledJob extends QuartzJobBean {

	@Override protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

		System.out.println(" i am SecondScheduledJob");
	}
}
