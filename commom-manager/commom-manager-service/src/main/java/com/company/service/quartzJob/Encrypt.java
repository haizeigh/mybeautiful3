package com.company.service.quartzJob;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by v-leiyu on 2017/12/26.
 */
@Component
public class Encrypt {

	@Scheduled(cron = "0/5 * * * * ?")
	public  void testEncrypt(){
		System.out.println("计划 不断进行加密  解密");
		System.out.println(new Date());
	}
}
