package com.company.service.quartzJob;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;

/**
 * Created by v-leiyu on 2017/12/28.
 */

public class AutoJobMore extends QuartzJobBean {


	/*一般情况下，quartz的job中使用autowired注解注入的对象为空，这时候我们就要使用spring-quartz提供的AdaptableJobFactory类。
	* 建议使用 jobDataMap 的配置*/
	private QuartzCountService quartzCountService;

	public QuartzCountService getQuartzCountService() {
		return quartzCountService;
	}

	public void setQuartzCountService(QuartzCountService quartzCountService) {
		this.quartzCountService = quartzCountService;
	}

	@Override protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println("test count");
		quartzCountService.Count();
	}
}
