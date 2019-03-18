package com.company.service.test;

import redis.clients.jedis.Jedis;

/**
 * Created by v-leiyu on 2018/2/5.
 */
public class TestRedis {
	public static void main(String[] args) {
		//ubuntu 的redis 配置文件 /etc/redis/redis.conf 查看是否将默认只能本地访问redis改为所有IP均可以访问 bind 127.0.0.1 改为 bind 0.0.0.0
		///etc/init.d/redis-server restart (不重启,你修改的配置不会生效)
		Jedis jedis=new Jedis("10.200.114.43",6379);
		jedis.set("age","26");
		String ping = jedis.ping();
		System.out.println(ping);
		System.out.println(jedis.get("age"));

	}


}
