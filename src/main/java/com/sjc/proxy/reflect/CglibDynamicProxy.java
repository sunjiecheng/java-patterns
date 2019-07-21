package com.sjc.proxy.reflect;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;

/**
 * @author jiecheng
 * @create 2019-07-21 上午9:38
 */
public class CglibDynamicProxy implements MethodInterceptor {

    private Object target;

    public Object getProxyClass(Object target) {
        this.target = target;
        // 加强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("日志开始");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("日志结束");
        return result;
    }

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"code");

        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
        List v = (List) cglibDynamicProxy.getProxyClass(new Vector(10));
        v.add(1);
    }
}
