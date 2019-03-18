package com.company.service.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by v-leiyu on 2017/12/21.
 */
public class FirstScheduledJob extends QuartzJobBean {


	private AnotherBean anotherBean;

	public AnotherBean getAnotherBean() {
		return anotherBean;
	}

	public void setAnotherBean(AnotherBean anotherBean) {
		this.anotherBean = anotherBean;
	}

	@Override protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

		System.out.println("this is FirstScheduledJob");
		anotherBean.anotherBeanPrint();
	}
}
