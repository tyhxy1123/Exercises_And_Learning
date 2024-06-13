package com.javacode2020.lesson002.staticProxy;

import org.springframework.stereotype.Component;

@Component
public class ServiceA implements IService {
    @Override
    public void m1() {
        System.out.println("This is m1 method of ServiceA");
    }

    @Override
    public void m2() {
        System.out.println("This is m2 method of ServiceA");
    }

    @Override
    public void m3() {
        System.out.println("This is m3 method of ServiceA");
    }
}
