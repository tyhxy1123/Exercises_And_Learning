package com.javacode2018.lesson001.demo1

import org.springframework.context.support.ClassPathXmlApplicationContext

fun context(beanXml: String): ClassPathXmlApplicationContext {
    return ClassPathXmlApplicationContext(beanXml)
}