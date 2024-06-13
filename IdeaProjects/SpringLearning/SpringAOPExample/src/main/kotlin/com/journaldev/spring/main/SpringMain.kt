package com.journaldev.spring.main

import com.journaldev.spring.service.EmployeeService
import org.springframework.context.support.ClassPathXmlApplicationContext

fun main(args:Array<String>){
    val context = ClassPathXmlApplicationContext("classpath:employeeBean.xml")
    val employeeService = context.getBean("emloyeeService", EmployeeService::class.java)
    println(employeeService.employee)
    employeeService.employee!!.name="张三"



    context.close()

}