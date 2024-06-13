package com.javacode2018.lesson001.demo1

import org.springframework.context.support.ClassPathXmlApplicationContext

fun main(args: Array<String>) {
    val beanXml = "classpath:bean.xml";
    val context = ClassPathXmlApplicationContext(beanXml)
    val helloWorld = context.getBean("helloworld", HelloWorld::class.java)
    helloWorld.say()

}