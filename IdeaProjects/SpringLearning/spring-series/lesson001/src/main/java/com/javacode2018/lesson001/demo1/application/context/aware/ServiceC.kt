package com.javacode2018.lesson001.demo1.application.context.aware

open class ServiceC {
    //    open var serviceA:ServiceA? = null
    open fun getServiceA(): ServiceA? {
        return null
    }

    fun say() {
        println("this: $this, ServiceA: " + getServiceA())
    }
}