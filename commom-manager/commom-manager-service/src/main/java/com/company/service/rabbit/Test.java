package com.company.service.rabbit;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * Created by v-leiyu on 2018/1/7.
 */
public class Test {
	public static void main(String[] args) {
		try {
			QueueConsumer queueConsumer=new QueueConsumer("queue");
			Thread thread=new Thread(queueConsumer);
			thread.start();

			Producer producer=new Producer("queue");
			for (int i = 0; i < 10000000; i++) {
				HashMap message = new HashMap();
				message.put("message number", i);
				producer.sendMessage(message);
				System.out.println("Message Number "+ i +" sent.");
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
}
