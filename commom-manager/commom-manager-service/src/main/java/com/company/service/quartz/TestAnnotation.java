package com.company.service.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by v-leiyu on 2017/12/22.
 */
@Component
public class TestAnnotation {

	/*@Scheduled(cron = "0/5 * * * * ?")*/
	public void test(){
		System.out.println("Hello Quartz!");
	}
}
