package com.company.service.rabbit;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by v-leiyu on 2018/1/7.
 */
public class QueueConsumer extends EndPoint implements Runnable,Consumer {
	public QueueConsumer(String endpointName) throws IOException, TimeoutException {
		super(endpointName);
	}
	@Override public void run() {

		try {
			channel.basicConsume(endPointName,true,this);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override public void handleConsumeOk(String s) {
		System.out.println("Consumer "+s +" registered");
	}

	@Override public void handleCancelOk(String s) {

	}

	@Override public void handleCancel(String s) throws IOException {

	}

	@Override public void handleShutdownSignal(String s, ShutdownSignalException e) {

	}

	@Override public void handleRecoverOk(String s) {

	}

	@Override public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties,
			byte[] bytes) throws IOException {
		Map<String,Object> map = (HashMap)SerializationUtils.deserialize(bytes);
		System.out.println("打印map");
		for (String  key:map.keySet()){
			System.out.println(key+"----"+map.get(key));
		}
		System.out.println("Message Number "+ map.get("message number") + " received.");

	}


}
