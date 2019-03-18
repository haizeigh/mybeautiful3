package com.company.fcade;

import com.company.pojo.model.JobEntity;

import java.util.List;

/**
 * Created by v-leiyu on 2017/12/29.
 */
public interface QuartzJobServiceFcade {
	//获取定时job列表
	List<JobEntity> selectJobAllList();

	String pauseJob(String jobName, String jobGroupName);

	String addJob(JobEntity jobEntity);

	String reviveJob(String jobName, String jobGroupName);

	String deleteJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName);

	JobEntity selectAnJob(String jobName, String jobGroupName);

	boolean modifyJobTime(JobEntity jobEntity);
}
