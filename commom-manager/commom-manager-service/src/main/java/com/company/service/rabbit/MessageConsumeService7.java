package com.company.service.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by v-leiyu on 2018/1/7.
 */

public class MessageConsumeService7 implements MessageListener {

	@Override public void onMessage(Message message) {
		System.out.println("动态测试广播交换机的监听"+message.getMessageProperties().getReceivedExchange()+"---"+message.getMessageProperties().getReceivedRoutingKey()+"---"+new String(message.getBody()));

	}
}
