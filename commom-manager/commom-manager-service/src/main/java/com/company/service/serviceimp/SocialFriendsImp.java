package com.company.service.serviceimp;

import com.company.fcade.SocialFriendsInte;
import com.company.pojo.dao.SocialDynamicDao;
import com.company.pojo.model.SocialDynamic;
import com.company.pojo.model.SocicalUser;
import com.company.service.curatorLock.DistributeLock;
import com.company.service.db.DataEnum;
import com.company.service.db.DataSelecter;
import com.company.service.rabbit.MessageProductService;
import com.company.service.serviceimp.service.SocialFriendService;
import com.company.utils.DateUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by v-leiyu on 2017/12/1.
 */
@Service("socialFriendsService")
public class SocialFriendsImp implements SocialFriendsInte {

	org.slf4j.Logger logger=LoggerFactory.getLogger(SocialFriendsImp.class);
	{
		System.out.println("SocialFriendsImp 实例化");
	}

	@Resource(name = "amqpTemplate")
	private AmqpTemplate amqpTemplate;

	@Resource(name = "amqpTemplateFanout")
	private AmqpTemplate amqpTemplateFanout;
	//amqpTemplateTopic
	@Resource(name = "amqpTemplateTopic")
	private AmqpTemplate amqpTemplateTopic;

	//amqpTemplateFanoutTest
	@Resource(name = "amqpTemplateFanoutTest")
	private AmqpTemplate amqpTemplateFanoutTest;

	@Resource
	private SocialDynamicDao socialDynamicDao;

//	@Qualifier("ftpLock")  可以使用Qualifier指定具体bean的name
	@Resource
	private SocialFriendService socialFriendService;

	@Resource
	private MessageProductService messageProductService;


	public List<SocialDynamic> findAllSocialDynamic() {
		System.out.println(0);
		testLock();
		List<SocialDynamic> socialDynamics = getSocialDynamics();
		if (socialDynamics==null || socialDynamics.size()==0){
			System.out.println("用户没有动态");
		}
	/*	for (SocialDynamic socialDynamic:socialDynamics){
			messageProductService.sendMes(socialDynamic);
		}*/

		/*amqpTemplate.convertAndSend("red","red");
		amqpTemplate.convertAndSend("black","black");

		amqpTemplateFanout.convertAndSend("广播red");
		amqpTemplateFanout.convertAndSend("广播black");
//动态
		amqpTemplateFanoutTest.convertAndSend("dongtai__ceshi");

		amqpTemplateTopic.convertAndSend("topic.red","主题red");
		amqpTemplateTopic.convertAndSend("topic.black","主题black");

		changeQueue();*/
		return socialDynamics;
	}

	@Autowired
	DistributeLock distributeLock;

	public void testLock(){
		//这个能够保证同一时刻只有一个线程获得锁，没有获得锁的线程直接返回false，不会等待。
//		DistributeLock distributeLock=new DistributeLock("ceshi");
		try {
			logger.info("尝试获得锁");
			if (distributeLock.tryLock()){
				System.out.println("测试锁成功");
				System.out.println("测试睡眠");
				Thread.sleep(100);
				System.out.println("睡眠结束");
			}else {
				logger.info("失败获得锁");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			distributeLock.unLock();
		}
	}

	//	@DataSelecter(dateType = DataEnum.SalverData)
	//这里执行切面注解无效，因为这个bean是dubbo管理的。使用一个服务层执行切面的相关逻辑
	public List<SocialDynamic> getSocialDynamics() {
		return socialFriendService.getSocialDynamics();
	}

	@Resource(name = "messageReceiver8")
	private MessageListener messageReceiver8;

	@Resource(name = "exchangeFanoutTest")
	private FanoutExchange exchangeFanoutTest;

	//rabbitAdmin
	@Resource(name = "rabbitAdmin")
	private RabbitAdmin rabbitAdmin;

	//messageListenerContainer
	@Resource(name = "connectionFactory")
	private ConnectionFactory connectionFactory;


	private void  changeQueue(){
		//定义队列
		Queue ceshiQueue = new Queue("ceshi");
		rabbitAdmin.declareQueue(ceshiQueue);
		//绑定交换机 和 队列的关系
		rabbitAdmin.declareBinding(new Binding("ceshi", Binding.DestinationType.QUEUE,"exchangeFanoutTest","",null));


		//获得 监听容器
		SimpleMessageListenerContainer simpleMessageListenerContainer=new SimpleMessageListenerContainer(connectionFactory);
		// 设置容器的 队列 以及  监听器的 熟悉
		simpleMessageListenerContainer.addQueueNames("ceshi");
		simpleMessageListenerContainer.setMessageListener(messageReceiver8);
		//这个 确保启动 监听器监听队列
		 simpleMessageListenerContainer.start();
	}


	@Override public void testDubbo() {

		System.out.println(DateUtils.toString(new Date(),"yyyy-MM-dd HH:mm:ss.SSS")+":开始调用dubbo服务端的方法");
		try {
			//dubbo消费端在timeout时间内没有收到回复将会重试，timeout时间是配置的文件里面的
			//默认重试2次，超时时间是1s
			Thread.sleep(50000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(DateUtils.toString(new Date(),"yyyy-MM-dd HH:mm:ss.SSS")+":结束dubbo服务端的方法");
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/spring.xml");
		SocialFriendsImp a=(SocialFriendsImp)applicationContext.getBean("socialFriendsService");
		a.findAllSocialDynamic();
		/*String[] str=applicationContext.getBeanDefinitionNames();
		for (String string : str) {
			System.out.println("..."+string);
		}*/
	}

	public SocicalUser login(String userName){
		return  socialFriendService.login(userName);
	}
}
