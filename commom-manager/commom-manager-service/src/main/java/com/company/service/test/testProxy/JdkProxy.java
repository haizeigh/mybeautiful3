package com.company.service.test.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yl
 * @date 2019-12-24
 */
public class JdkProxy implements InvocationHandler {

    private Object target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理开始监听");
        //这里执行 target 的反射方法
        Object invoke = method.invoke(target, args);
        System.out.println("jdk动态代理结束监听");
        return invoke;
    }

    private Object getJdkProxy(Object targetObject){
        this.target = targetObject;
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader()
                , targetObject.getClass().getInterfaces()
                , this);
    }

    public static void main(String[] args) {
        JdkProxy jdkProxy =new JdkProxy();
        //这里用接口类  targetObject.getClass().getInterfaces()  表示父类
        UserManager userManager = (UserManager)jdkProxy.getJdkProxy(new UserManagerImpl());
        userManager.addUser("u", "p");
    }
}
