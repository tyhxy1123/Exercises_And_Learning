package com.javacode2020.lesson002.dynamicProxy;

import com.javacode2020.lesson002.dynamicProxy.IService;
import org.springframework.stereotype.Component;

@Component
public class ServiceB implements IService {
    @Override
    public void m1() {
        System.out.println("This is m1 method of ServiceB");
    }

    @Override
    public void m2() {
        System.out.println("This is m2 method of ServiceB");
    }

    @Override
    public void m3() {
        System.out.println("This is m3 method of ServiceB");
    }
}
