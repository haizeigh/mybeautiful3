package com.company.service.test.testProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yl
 * @date 2019-12-26
 */
public class CGLIBProxy implements MethodInterceptor {

    private Object target;


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib开始监听");
        Object invoke = method.invoke(target, objects);
        System.out.println("cglib结束监听");
        return invoke;
    }

    private Object getCglibProxy(Object targetObject){
        target  = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(targetObject.getClass());

        Object r = enhancer.create();
        return r;
    }

    public static void main(String[] args) {
        UserManagerImpl userManager = new UserManagerImpl();

        CGLIBProxy cglibProxy = new CGLIBProxy();
        // 这里直接是代理的类 UserManagerImpl，  当然也可以使用父类
        UserManagerImpl cglibProxy1 = (UserManagerImpl) cglibProxy.getCglibProxy(userManager);
//        UserManager cglibProxy1 = (UserManager) cglibProxy.getCglibProxy(userManager);
        cglibProxy1.addUser("张","pwd");
    }
}
