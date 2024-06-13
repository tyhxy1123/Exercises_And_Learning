package com.journaldev.spring.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before


@Aspect
class EmployeeAspectPointcut {
    @Before("getNamePointcut()")
    fun loggingAdvice(){
        println("Executing loggingAdvice on getName()")
    }

    @Before("getNamePointcut()")
    fun secondNamePointcut(){
        println("Executing secondAdvice on getName()")
    }

    @Before("getNamePointcut()")
    fun getNamePointcut(){}

    @Before("allMethodsPointcut()")
    fun allServiceMethodsAdvice(){
        println("Before executing service method")
    }
}