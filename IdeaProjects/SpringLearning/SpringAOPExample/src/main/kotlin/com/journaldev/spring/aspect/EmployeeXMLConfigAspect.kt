package com.journaldev.spring.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Aspect


@Aspect
class EmployeeXMLConfigAspect {
    fun employeeAroundAdvice(proceedingJoinPoint: ProceedingJoinPoint):Any{
        println("EmployeeXMLConfigAspect:: Before invoking getName() method")
        val value = proceedingJoinPoint.proceed()
        println("EmployeeXMLConfigAspect:: After invoking getName() method. Return value=$value")
        return value
    }
}