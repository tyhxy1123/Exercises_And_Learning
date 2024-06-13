package com.javacode2018.lesson001.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        var beanXml = "classpath:bean.xml";

        var context = new ClassPathXmlApplicationContext(beanXml);

        var helloWorld = context.getBean("HelloWorld", HelloWorld.class);
    }
}
