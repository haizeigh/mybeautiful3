package com.company.service.quartzJob;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by v-leiyu on 2017/12/28.
 */

public class QuartzCountService implements Serializable {
	private int i;

//	序列化是再配置的scheduler的dataSource中，以及配合quartz.properties文件，暂时放到web模块
	public void Count(){
		System.out.println("如果序列化了，属性不增加 。。。我在计数——"+i++);
	}
}
