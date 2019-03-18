package com.company.service.test;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by v-leiyu on 2018/2/6.
 */
@FixMethodOrder
public class TestRedis2 {

	public  static ApplicationContext ctx;
	public  static JedisConnectionFactory jedisConnectionFactory;

	public JedisConnection jedisConnection;

	@BeforeClass
	public static  void setBeforeClass(){
		ctx=new ClassPathXmlApplicationContext("config/redis.xml");
		jedisConnectionFactory= (JedisConnectionFactory)ctx.getBean("jedisConnectionFactory");
	}

	@Before
	public  void  setBedore(){
		jedisConnection= (JedisConnection)jedisConnectionFactory.getConnection();
	}

	@After
	public  void  setAfter(){
		jedisConnection.close();
	}

	private void print(Collection<RedisServer> c) {
		for (Iterator<RedisServer> iter = c.iterator(); iter.hasNext();) {
			RedisServer redisServer=iter.next();
			System.out.println(redisServer.getHost()+":"+redisServer.getPort());
		}
	}

	@Ignore
	@Test
	public void test1(){
		if (!jedisConnection.exists(new String("zz").getBytes())){
			jedisConnection.set(new String("zz").getBytes(),new String("zz").getBytes());
		}
	}

	@Ignore
	@Test
	public void test2() {
		Set<byte[]> keys = jedisConnection.keys(new String("*").getBytes());
		for (Iterator<byte[]> iter = keys.iterator(); iter.hasNext();) {
			System.out.println(new String(iter.next()));
		}
	}

	@Ignore
	@Test
	public void test3() throws InterruptedException {
		if (jedisConnectionFactory.getSentinelConnection().isOpen()){
			Collection<RedisServer> masters = jedisConnectionFactory.getSentinelConnection().masters();
			print(masters);
			RedisNode redisNode=new RedisNode("10.200.114.48",6379);
			redisNode.setName("mymaster");

			Collection<RedisServer> slaves = jedisConnectionFactory.getSentinelConnection().slaves(redisNode);
			print(slaves);
		}

		if (jedisConnectionFactory.getSentinelConnection().isOpen()) {
			Collection<RedisServer> c = jedisConnectionFactory
					.getSentinelConnection().masters();
			print(c);
			RedisNode rn = new RedisNode("192.168.88.153", 6380);
			rn.setName("mymaster");
			c = jedisConnectionFactory.getSentinelConnection().slaves(rn);
			print(c);
		}

		for (int i = 0; i < 1000; i++) {
			jedisConnection.set(new String("k" + i).getBytes(), new String("v"
					+ i).getBytes());
			Thread.sleep(1000);
		}
		Set<byte[]> keys = jedisConnection.keys(new String("k*").getBytes());
		Assert.assertEquals(1000, keys.size());
	}

}
