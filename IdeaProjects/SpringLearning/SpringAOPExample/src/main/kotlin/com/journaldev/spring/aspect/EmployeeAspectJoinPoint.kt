package com.journaldev.spring.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import java.util.*

@Aspect
class EmployeeAspectJoinPoint {
    @Before("execution(public void com.journaldev.spring.model..set*(*))")
    fun logginAdvice(joinPoint: JoinPoint) {
        println("Before running loggingAdvice on method=$joinPoint")
        println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()))
    }

    @Before("args(name)")
    fun logStringArguments(name: String) {
        println("String argument passed=$name")
    }


}