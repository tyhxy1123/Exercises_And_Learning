package com.journaldev.spring.model

import com.journaldev.spring.aspect.Loggable

class Employee {
    var name:String? = null
        @Loggable set(name:String?){
            field = name
        }


}