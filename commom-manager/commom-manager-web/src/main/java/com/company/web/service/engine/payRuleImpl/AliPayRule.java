package com.company.web.service.engine.payRuleImpl;

import com.company.web.service.engine.PayEngine;
import com.company.web.service.engine.PayRule;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by v-leiyu on 2018/3/30.
 */
@Service
public class AliPayRule implements PayRule {

	@PostConstruct
	public void register(){
		PayEngine.register("ali", this);
	}

	@Override public String pay(Map requestMap) {
		System.out.println("开始处理ali支付");
		return null;
	}
}
