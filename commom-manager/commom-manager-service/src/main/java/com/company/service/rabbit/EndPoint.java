package com.company.service.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by v-leiyu on 2018/1/7.
 */
public class EndPoint {

	protected String endPointName;
	protected Connection connection;
	protected Channel channel;
	public EndPoint (String endpointName) throws IOException, TimeoutException {
		this.endPointName = endpointName;
		ConnectionFactory connectionFactory=new ConnectionFactory();

		connectionFactory.setHost("192.168.119.128");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("asdf");
		connectionFactory.setPassword("123456");


		connection = connectionFactory.newConnection();

		channel = connection.createChannel();

//		声明一个名叫endpointName的queue
		channel.queueDeclare(endpointName,false,false,false,null);

	}


	public void close() throws IOException, TimeoutException {
		this.channel.close();
		this.connection.close();
	}
}
