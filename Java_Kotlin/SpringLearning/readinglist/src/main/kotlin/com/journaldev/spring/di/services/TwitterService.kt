package com.journaldev.spring.di.services

import com.journaldev.spring.di.services.IMessageService

class TwitterService: IMessageService {
    override fun sendMessage(msg: String, rec: String): Boolean {
        println("Twitter message sent to $rec with Message=$msg")
        return true
    }
}