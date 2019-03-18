package com.company.service.quartz;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by v-leiyu on 2017/12/21.
 */
@Component("myBean")
public class MyBean implements Serializable {
	private String uid;
	private String pwd;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void printMessage() {
		System.out.println("I am MyBean. I am called by MethodInvokingJobDetailFactoryBean using SimpleTriggerFactoryBean");
	}
}
