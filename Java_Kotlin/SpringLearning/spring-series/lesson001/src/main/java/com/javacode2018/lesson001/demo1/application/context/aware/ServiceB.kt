package com.javacode2018.lesson001.demo1.application.context.aware

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

class ServiceB : ApplicationContextAware {
    private val serviceA: ServiceA?
        get() = context?.getBean(ServiceA::class.java)

    var context: ApplicationContext? = null
    override fun setApplicationContext(p0: ApplicationContext) {
        context = p0
    }

    override fun toString(): String {
        return "ServiceB(context=$context, serviceA=$serviceA)"
    }

}