package com.journaldev.spring.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect

@Aspect
class EmployeeAroundAspect {
    @Around("execution(* com.journaldev.spring.model.Employee.getName())")
    fun employeeAroundAdvice(proceedingJoinPoint: ProceedingJoinPoint): Any {
        println("Before invoking getName() method")
        val value = proceedingJoinPoint.proceed();
        println("After invoking getName() method. Return value=$value")
        return value
    }
}