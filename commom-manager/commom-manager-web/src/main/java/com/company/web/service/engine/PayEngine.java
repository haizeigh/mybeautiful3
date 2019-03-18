package com.company.web.service.engine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by v-leiyu on 2018/3/30.
 */
public class PayEngine {

	public  static final Map<String,PayRule> payRuleMap=new ConcurrentHashMap<>();

	public  static void register(String key, PayRule payRule){
		System.out.println("注册"+key+"到支付系统了。");
		payRuleMap.put(key,payRule);
	}

	public static PayRule getPayRule(String key){
		PayRule payRule = payRuleMap.get(key);
		if (payRule==null){
			System.out.println("找不到支付方式");
			throw new  RuntimeException("找不到支付方式");
		}
		return  payRule;
	}


}
