package com.company.web.annotation;

import java.lang.annotation.*;

/**
 * Created by v-leiyu on 2018/3/30.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PayRuleRegister {

	public String serviceName();

	public String suffix() default "测试";
}
