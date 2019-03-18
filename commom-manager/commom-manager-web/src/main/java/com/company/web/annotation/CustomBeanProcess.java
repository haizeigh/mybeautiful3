package com.company.web.annotation;

import com.company.web.service.engine.PayEngine;
import com.company.web.service.engine.PayRule;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by v-leiyu on 2018/3/30.
 */
@Component
public class CustomBeanProcess implements BeanPostProcessor {



	@Override public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
		return bean;
	}

	@Override public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
		//如果是注解PayRuleRegister  就是代表 需要注入payrule
		if (bean.getClass().isAnnotationPresent(PayRuleRegister.class) && bean instanceof PayRule){
			PayRuleRegister annotation = bean.getClass().getAnnotation(PayRuleRegister.class);
			System.out.println("开始注册支付方式"+annotation.suffix());
			PayEngine.register(annotation.serviceName(),(PayRule)bean);
		}
		return bean;
	}
}
