package com.javacode2020.lesson002.dynamicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.stereotype.Component;

@Component
public class FixedValueProxy {
    private Service1 service1;

    public Service1 getService1() {
        return service1;
    }

    public FixedValueProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Service1.class);
        enhancer.setCallback((FixedValue)()->{
            System.out.println("fixed value intercepted");
            return null;
        });
        service1 = (Service1) enhancer.create();
    }
}
