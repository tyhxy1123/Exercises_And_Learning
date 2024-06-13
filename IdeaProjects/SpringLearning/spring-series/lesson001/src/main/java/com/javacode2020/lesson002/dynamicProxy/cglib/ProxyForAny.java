package com.javacode2020.lesson002.dynamicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("anyProxyFactory")
public class ProxyForAny {
    public <T>T createProxy(T target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                long start = System.nanoTime();
                var result = method.invoke(target, objects);
                long end = System.nanoTime();
                System.out.println(methodProxy + ", 耗时: " + (end - start));
                return result;
            }
        });
        return (T) enhancer.create();
    }
}
