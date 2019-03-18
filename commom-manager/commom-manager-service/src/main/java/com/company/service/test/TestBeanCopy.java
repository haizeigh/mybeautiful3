package com.company.service.test;


import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tomyu on 2018/12/4.
 */
public class TestBeanCopy {
	public static void main(String[] args) {

		C c1=new C();
		c1.setAge("10");
		c1.getHome().put("ip","10");

		C c2=new C();
		c2.setAge("20");
		c2.getHome().put("ip","20");


		A a=new A();
		a.setName("name");
		a.setAge("age");
		a.getMymap().put("testK","testV");
		a.setC(c1);

		B b=new B();
		//使用BeanUtils，bean里面要有set get 方法
		//a对象里属性多或者少没关系  相同名字的目标属性会复制到目标对象
		BeanUtils.copyProperties(a,b);
		System.out.println(b);

		A a2=new A();
		a2.setC(c2);
		BeanUtils.copyProperties(b,a2);
		System.out.println(a2);

		//如果目标属性有值，会覆盖
		b.setName("name2");
		b.getMymap().put("testK","testV2");
		b.getMymap().put("testK5","testV5");
		BeanUtils.copyProperties(b,a);
		System.out.println(a);


	}

}

class A{
	private  String name;
	private String age;
	private Map<String,Object> mymap=new HashMap<>();

	private  C c;

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Map<String, Object> getMymap() {
		return mymap;
	}

	public void setMymap(Map<String, Object> mymap) {
		this.mymap = mymap;
	}
}

class B{
	private String name;
	private Map<String,Object> mymap=new HashMap<>();

	private  C c;

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getMymap() {
		return mymap;
	}

	public void setMymap(Map<String, Object> mymap) {
		this.mymap = mymap;
	}
}

class C{
	private String age;
	private Map<String,Object> home=new HashMap<>();

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Map<String, Object> getHome() {
		return home;
	}

	public void setHome(Map<String, Object> home) {
		this.home = home;
	}
}
