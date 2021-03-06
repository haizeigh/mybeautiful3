package com.company.service.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

/**
 * Created by v-leiyu on 2018/1/7.
 */

public class MessageConsumeService implements MessageListener {

	@Override public void onMessage(Message message) {
		System.out.println("直接交换机的一号监听"+message.getMessageProperties().getReceivedExchange()+"---"+message.getMessageProperties().getReceivedRoutingKey()+"---"+new String(message.getBody()));
	}
}
