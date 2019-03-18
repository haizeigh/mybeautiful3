package com.company.service.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by v-leiyu on 2018/1/7.
 */
@Service
public class MessageProductService {


	@Resource
	private AmqpTemplate amqpTemplate;

	public void sendMes(Object object){
		amqpTemplate.convertAndSend("queueTestKey",object);
	}



}
