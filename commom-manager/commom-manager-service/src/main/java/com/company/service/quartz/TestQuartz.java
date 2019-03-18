package com.company.service.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

import java.io.*;

/**
 * Created by v-leiyu on 2017/12/21.
 */
public class TestQuartz {
	public static void main(String[] args) {

		//ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/quartz.xml");
		JobKey jobKey =new JobKey("job1","group1");
		JobKey jobKey2 =new JobKey("job1","group2");
		JobDetail jobDetail=JobBuilder.newJob(HelloJob.class).withIdentity(jobKey).build();
		Trigger trigger=TriggerBuilder.newTrigger()
				.withIdentity("trigger1","group2")
				.withSchedule(
//						SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()
						CronScheduleBuilder.cronSchedule("0,30 0/1 * * * ?")
				).build();
		SchedulerFactory schedulerFactory=new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = schedulerFactory.getScheduler();

			scheduler.getListenerManager().addJobListener(new HelloJobListener(), KeyMatcher.keyEquals(jobKey));
			scheduler.scheduleJob(jobDetail,trigger);
			scheduler.start();
		}
		catch (SchedulerException e) {
			e.printStackTrace();
		}
		try {
//			Thread.sleep(8000);
//			scheduler.shutdown();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}


	public  void out(){
//		HelloJob helloJob=new HelloJob();
		HelloJob helloJob=new HelloJob();
		/*ObjectMapper objectMapper=new ObjectMapper();
		try {
			objectMapper.writeValue(new File("E:\\22.txt"),helloJob);
		}
		catch (IOException e) {
			e.printStackTrace();
		}*/
		File file=new File("E:\\22.txt");
		try {
			FileOutputStream fileOutputStream=new FileOutputStream(file);
			ObjectOutputStream os=new ObjectOutputStream(fileOutputStream);
			os.writeObject(helloJob);
			os.flush();
			os.close();
			fileOutputStream.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	public  void in(){
//		HelloJob helloJob=new HelloJob();

		File file=new File("E:\\22.txt");
		try {
			FileInputStream fileInputStream=new FileInputStream(file);
			ObjectInputStream oi=new ObjectInputStream(fileInputStream);
			Job myBean = (Job)oi.readObject();
			myBean.execute(null);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

