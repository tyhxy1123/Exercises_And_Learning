package com.javacode2020.lesson002.dynamicProxy.cglib;

import org.springframework.stereotype.Component;

@Component("demo")
public class Service1 {
    public void m1(){
        System.out.println("this is m1()");
        this.m2();
    }

    public void m2(){
        System.out.println("this is m2()");
    }
}
