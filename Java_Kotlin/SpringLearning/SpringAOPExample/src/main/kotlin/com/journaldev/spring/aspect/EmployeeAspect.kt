package com.journaldev.spring.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before


@Aspect
class EmployeeAspect {
    @Before("execution(getName():String)")
    fun getNameAdvice(){
        println("Executing Advice on getName()")
    }

    @Before("excution(*com.journaldev.spring.service.*.get*())")
    fun getAllAdvice(){
        println("Service method getter called")
    }
}