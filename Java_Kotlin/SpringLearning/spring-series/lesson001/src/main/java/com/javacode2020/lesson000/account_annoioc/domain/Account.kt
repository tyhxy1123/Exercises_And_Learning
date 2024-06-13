package com.javacode2020.lesson000.account_annoioc.domain

import java.io.Serializable
import kotlin.properties.Delegates

class Account:Serializable {

    var id:Int?=0
    var name:String? = null
    var money:Float? = null

    override fun toString(): String {
        return "Account(id=$id, name='$name', money=$money)"
    }
}