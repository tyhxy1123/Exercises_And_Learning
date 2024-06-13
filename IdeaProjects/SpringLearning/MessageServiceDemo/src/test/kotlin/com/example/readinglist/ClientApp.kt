package com.journaldev.spring.di.test

import di.configuration.DIConfiguration
import com.journaldev.spring.di.consumer.MessageApplication
import org.junit.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext


class ClientApp {
    @Test
    fun clientStartTest(){
        val context = AnnotationConfigApplicationContext(DIConfiguration::class.java)
        val app = context.getBean(MessageApplication::class.java)
        app.processMessage("Hi 张三","zhangsan@abc.com")
    }
}