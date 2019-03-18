package com.company.service.serviceimp;

import com.company.fcade.QuartzJobServiceFcade;
import com.company.pojo.model.JobEntity;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by v-leiyu on 2017/12/29.
 */
@Service("quartzJobService")
public class QuartzJobService implements QuartzJobServiceFcade {

	@Autowired
	private Scheduler scheduler;

	@Override public List<JobEntity> selectJobAllList() {
		System.out.println("开始查找任务");
		List<JobEntity> jobEntityList=new ArrayList<>();
		try {
			//找到触发器组名 的集合
			List<String> triggerGroupNameSet = scheduler.getTriggerGroupNames();
			for (String triggerGroupName:triggerGroupNameSet){
				//根据组名，得到触发器的 key
				Set<TriggerKey> triggerKeySet = scheduler
						.getTriggerKeys(GroupMatcher.triggerGroupEquals(triggerGroupName));
				for (TriggerKey triggerKey:triggerKeySet){
					Trigger trigger = scheduler.getTrigger(triggerKey);
					if (trigger instanceof CronTrigger){
						JobEntity jobEntity=new JobEntity();
						CronTrigger cronTrigger = (CronTrigger)trigger;
						//得到定时任务的 key
						JobKey jobKey = cronTrigger.getJobKey();
						JobDetail jobDetail = scheduler.getJobDetail(jobKey);
						//设置参数
						jobEntity.setJobName(jobKey.getName());
						jobEntity.setJobGroup(jobKey.getGroup());

						jobEntity.setTriggerName(triggerKey.getName());
						jobEntity.setTriggerGroup(triggerKey.getGroup());

						jobEntity.setCronExpr(cronTrigger.getCronExpression());
						jobEntity.setNextFireTime(trigger.getNextFireTime());
						jobEntity.setPreviousFireTime(trigger.getPreviousFireTime());
						jobEntity.setStartTime(trigger.getStartTime());
						jobEntity.setEndTime(trigger.getEndTime());
						jobEntity.setJobClass(jobDetail.getJobClass().getCanonicalName());

						Trigger.TriggerState triggerState = scheduler.getTriggerState(triggerKey);
						// 	NONE NORMAL PAUSED	COMPLETE ERROR BLOCKED
						jobEntity.setJobStatus(triggerState.toString());

						JobDataMap map = jobDetail.getJobDataMap();
						if (null!=map && map.size()!=0){
//							jobEntity.setCount(Integer.parseInt((String)map.get("count"))); 暂时省略  获得执行次数
							jobEntity.setJobDataMap(map);
						}else
							jobEntity.setJobDataMap(new JobDataMap());

						jobEntityList.add(jobEntity);
					}
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("结束查找任务");
		return jobEntityList;

	}

	@Override public String pauseJob(String jobName, String jobGroupName) {
		try {
			scheduler.pauseJob( JobKey.jobKey(jobName,jobGroupName));
			return  "success";
		}
		catch (SchedulerException e) {
			e.printStackTrace();
			return  "wrong";
		}
	}

	@Override public String reviveJob(String jobName, String jobGroupName) {
		try {
			scheduler.resumeJob( JobKey.jobKey(jobName,jobGroupName));
			return  "success";
		}
		catch (SchedulerException e) {
			e.printStackTrace();
			return  "wrong";
		}
	}

	@Override public String deleteJob(String jobName, String jobGroupName, String triggerName,
			String triggerGroupName) {

		try {
			//暂停触发器
			scheduler.pauseTrigger(TriggerKey.triggerKey(triggerName,triggerGroupName));
			//移除触发器
			scheduler.unscheduleJob(TriggerKey.triggerKey(triggerName,triggerGroupName));
			//移除任务
			scheduler.deleteJob(JobKey.jobKey(jobName,jobGroupName));
			return  "success";
		}
		catch (SchedulerException e) {
			e.printStackTrace();
			return  "wrong";
		}
	}

	@Override public JobEntity selectAnJob(String jobName, String jobGroupName) {
		JobEntity jobEntity=new JobEntity();
		try {
			JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
			List<? extends Trigger> triggersOfJob = scheduler.getTriggersOfJob(JobKey.jobKey(jobName, jobGroupName));
			CronTrigger cronTrigger = (CronTrigger)triggersOfJob.get(0);
			JobKey jobKey = cronTrigger.getJobKey();

			jobEntity.setJobName(jobKey.getName());
			jobEntity.setJobGroup(jobKey.getGroup());
			jobEntity.setJobClass(jobDetail.getJobClass().getCanonicalName());

			TriggerKey key = cronTrigger.getKey();
			jobEntity.setTriggerName(key.getName());
			jobEntity.setTriggerGroup(key.getGroup());

			jobEntity.setCronExpr(cronTrigger.getCronExpression());
		}
		catch (SchedulerException e) {
			e.printStackTrace();
		}
		return jobEntity;
	}

	@Override public boolean modifyJobTime(JobEntity jobEntity) {
		JobEntity oldJobEntity = selectAnJob(jobEntity.getJobName(), jobEntity.getJobGroup());
		deleteJob(oldJobEntity.getJobName(),oldJobEntity.getJobGroup(),oldJobEntity.getTriggerName(),oldJobEntity.getTriggerGroup());
		addJob(jobEntity);
		return false;
	}

	@Override public String addJob(JobEntity jobEntity) {

		try {
			//建立jobdetail
			Class jobClass=Class.forName(jobEntity.getJobClass());
			JobDetail jobDetail= (JobDetail)JobBuilder.newJob(jobClass)
					.withIdentity(jobEntity.getJobName(),jobEntity.getJobGroup()).storeDurably(true).build();
			//建立触发器
			CronTrigger cronTrigger= (CronTrigger)TriggerBuilder.newTrigger()
					.withIdentity(jobEntity.getTriggerName(),jobEntity.getTriggerGroup())
					.withSchedule(
							CronScheduleBuilder.cronSchedule(jobEntity.getCronExpr())
					).build();
			//启动作业
			scheduler.scheduleJob(jobDetail,cronTrigger);
			if (!scheduler.isShutdown()){
				scheduler.start();
			}
			return "success";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "wrong";
		}
	}


}
