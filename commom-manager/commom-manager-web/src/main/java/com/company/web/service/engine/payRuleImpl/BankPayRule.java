package com.company.web.service.engine.payRuleImpl;

import com.company.web.annotation.PayRuleRegister;
import com.company.web.service.engine.PayRule;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by v-leiyu on 2018/3/30.
 */
@Service
@PayRuleRegister(serviceName = "b",suffix = "银行")
public class BankPayRule implements PayRule {
	@Override public String pay(Map requestMap) {
		System.out.println("银行的逻辑");
		return null;
	}
}
