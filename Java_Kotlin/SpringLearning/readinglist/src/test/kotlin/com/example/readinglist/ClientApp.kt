package com.journaldev.spring.di.test

import com.journaldev.spring.di.configuration.DIConfiguration
import com.journaldev.spring.di.consumer.MessageApplication
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.AnnotationConfigApplicationContext


@SpringBootTest
class ClientApp {
    @Test
    fun clientStartTest(){
        val context = AnnotationConfigApplicationContext(DIConfiguration::class.java)
        val app = context.getBean(MessageApplication::class.java)
        app.processMessage("Hi Pankaj","pankaj@abc.com")
    }
}