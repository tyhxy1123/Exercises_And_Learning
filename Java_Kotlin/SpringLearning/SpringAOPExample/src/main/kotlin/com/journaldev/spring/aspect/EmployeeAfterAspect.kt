package com.journaldev.spring.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect


@Aspect
class EmployeeAfterAspect {

    @After("args(name)")
    fun logStringArguments(name: String): Unit {
        println("Running After Advice. String argument passed=$name")
    }

    @AfterThrowing("within(com.journaldev.spring.model.Employee)")
    fun logExceptions(joinPoint: JoinPoint): Unit {
        println("Exception thrown in Employee Method=$joinPoint")
    }

    @AfterReturning(pointcut="execution(* getName())", returning="returnString")
    fun getNameReturningAdvice(returnString: String): Unit {
        println("getNameReturningAdvice executed. Returned String=$returnString")
    }

}