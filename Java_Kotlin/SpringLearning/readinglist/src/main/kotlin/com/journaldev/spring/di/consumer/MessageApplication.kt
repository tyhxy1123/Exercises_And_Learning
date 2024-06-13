package com.journaldev.spring.di.consumer

import com.journaldev.spring.di.services.IMessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MessageApplication {
    @Autowired
    private var service: IMessageService? = null
    fun processMessage(msg:String, rec:String):Boolean{
        return this.service!!.sendMessage(msg,rec)
    }
}