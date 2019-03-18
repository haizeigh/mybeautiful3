package com.company.pojo.model;

import lombok.Data;
import org.quartz.JobDataMap;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by v-leiyu on 2017/12/29.
 */
@Data
public class JobEntity  implements Serializable{
	private int jobId;
	private String jobType;
	private String jobName;
	private String jobGroup;

	private String triggerName;
	private String triggerGroup;
	private String cronExpr;

	private Date previousFireTime;
	private Date nextFireTime;

	private String jobStatus;

	private long runTimes;
	private long duration;

	private Date startTime;
	private Date endTime;

	private String jobMemo;
	private String jobClass;
	private String jobMethod;
	private String jobObject;

	private int count;

	private JobDataMap jobDataMap;

}
