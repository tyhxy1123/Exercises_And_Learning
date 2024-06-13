package com.javacode2018.lesson001.demo1.application.context.aware.method.replacer

import com.javacode2018.lesson001.demo1.application.context.aware.ServiceA
import org.springframework.beans.factory.support.MethodReplacer
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import java.lang.reflect.Method

class ServiceCMethodReplacer : MethodReplacer, ApplicationContextAware {
    var context: ApplicationContext? = null
    override fun reimplement(p0: Any, p1: Method, p2: Array<Any>): ServiceA? {
        return this.context?.getBean(ServiceA::class.java)
    }

    override fun setApplicationContext(p0: ApplicationContext) {
        context = p0
    }

}