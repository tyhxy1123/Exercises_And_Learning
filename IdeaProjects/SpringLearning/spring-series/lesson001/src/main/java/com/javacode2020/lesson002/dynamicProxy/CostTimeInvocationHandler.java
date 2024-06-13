package com.javacode2020.lesson002.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CostTimeInvocationHandler implements InvocationHandler {
    private Object target;

    public CostTimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object result = method.invoke(this.target, args);
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + ".m1() method took: " + (endTime-startTime) + " nanoseconds");
        return result;
    }

    public static <T> T createProxy(Object target, Class<T> targetInterface){
        if(!targetInterface.isInterface()){
            throw new IllegalStateException("目标接口不是接口");
        }
        if(!targetInterface.isAssignableFrom(target.getClass())){
            throw new IllegalStateException("目标非targetInterface的实现类");
        }
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new CostTimeInvocationHandler(target));
    }
}
