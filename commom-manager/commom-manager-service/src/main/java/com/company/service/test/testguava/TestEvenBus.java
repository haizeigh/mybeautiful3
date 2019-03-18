package com.company.service.test.testguava;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * Created by tomyu on 2018/11/2.
 */
public class TestEvenBus {
	public static void main(String[] args) {
		EventBus eventBus=new EventBus("test1");

		eventBus.register(new OrderLisener());

		eventBus.post(new OrderEvent("订单生成了"));
		eventBus.post("!!!!!!");
		eventBus.post(2365);
	}
}

class OrderLisener{

	@Subscribe
	public void listen(OrderEvent orderEvent){
		System.out.println("监听OrderEvent，msg="+orderEvent.getMeg());
	}

	@Subscribe
	public void listen(String msg){
		System.out.println("监听msg，msg="+msg);
	}


//如果EventBus发送的消息都不是订阅者关心的称之为DeadEvent。
	@Subscribe
	public void listen(DeadEvent msg){
		System.out.println("监听DeadEvent，msg="+msg);
		System.out.println("监听DeadEvent，event.value="+msg.getEvent().toString());
	}
}

class OrderEvent{
	String meg;

	public OrderEvent(String meg) {
		this.meg = meg;
	}

	public String getMeg() {
		return meg;
	}

	public void setMeg(String meg) {
		this.meg = meg;
	}
}
