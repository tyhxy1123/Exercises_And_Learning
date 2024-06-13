package com.javacode2020.lesson000.demo02.domain

import java.io.Serializable

class Account:Serializable {

    var id:Int? = null
    var name:String? = null
    var money:Float? = null

    override fun toString(): String {
        return "Account(id=$id, name='$name', money=$money)"
    }
}