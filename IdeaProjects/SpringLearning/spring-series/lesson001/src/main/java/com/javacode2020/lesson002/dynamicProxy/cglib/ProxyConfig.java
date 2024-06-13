package com.javacode2020.lesson002.dynamicProxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.context.annotation.*;

@ComponentScan
public class ProxyConfig {

    public static <T>T createProxy(Class<T> cls){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
                System.out.println("hello world");
                var result = methodProxy.invokeSuper(o, objects);
                System.out.println("over");
                return result;
            }
        );
        return (T) enhancer.create();
    }

    @Bean("service1")
    public Service1 createProxy(){
        return createProxy(Service1.class);
    }
}