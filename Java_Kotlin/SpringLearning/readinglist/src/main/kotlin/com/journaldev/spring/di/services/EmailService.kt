package com.journaldev.spring.di.services

class EmailService: IMessageService {
    override fun sendMessage(msg: String, rec: String): Boolean {
        println("Email sent to $rec with Message=$msg")
        return true
    }
}