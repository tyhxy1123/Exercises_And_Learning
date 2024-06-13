package com.journaldev.spring.di.configuration

import com.journaldev.spring.di.services.EmailService
import com.journaldev.spring.di.services.IMessageService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(value=["com.journaldev.spring.di.consumer"])
class DIConfiguration {
    @Bean
    fun getMessageService(): IMessageService {
        return EmailService()
    }
}