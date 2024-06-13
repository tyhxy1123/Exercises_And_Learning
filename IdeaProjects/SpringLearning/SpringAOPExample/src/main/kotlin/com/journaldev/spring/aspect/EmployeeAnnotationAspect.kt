package com.journaldev.spring.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before

@Aspect
class EmployeeAnnotationAspect {
    @Before("@annotation(com.journaladev.spring.aspect.Loggable)")
    fun myAdvice(): Unit {
        println("Executing myAdvice!!")
    }
}