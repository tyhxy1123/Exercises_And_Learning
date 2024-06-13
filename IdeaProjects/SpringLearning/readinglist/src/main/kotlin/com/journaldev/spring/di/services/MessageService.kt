package com.journaldev.spring.di.services

interface IMessageService {
    fun sendMessage(msg:String, rec:String):Boolean
}