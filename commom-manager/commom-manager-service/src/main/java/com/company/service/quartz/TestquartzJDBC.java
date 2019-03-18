package com.company.service.quartz;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by v-leiyu on 2017/12/23.
 */
public class TestquartzJDBC {
	private static Scheduler scheduler;
	public static void main(String[] args) {

		ApplicationContext app=new ClassPathXmlApplicationContext("config/quartz.xml");
		scheduler= (Scheduler)app.getBean("scheduler");

		JobDetail jobDetail= JobBuilder.newJob(HelloJob.class).withIdentity("helloJob","group1").storeDurably(true).build();

		Trigger  trigger= TriggerBuilder.newTrigger().withIdentity("trigger","group1").withSchedule(
				CronScheduleBuilder.cronSchedule("0/2 * * * * ?")
		).build();

		try {
			Scheduler scheduler= new StdSchedulerFactory().getScheduler();
			scheduler.scheduleJob(jobDetail,trigger);
			scheduler.start();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
