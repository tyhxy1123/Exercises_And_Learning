package com.javacode2018.lesson001.demo1

import org.springframework.context.support.ClassPathXmlApplicationContext

fun buildUser2(name: String, age: Int): UserModel = UserModel(name, age)
fun buildUser1(): UserModel {
    val user = UserModel()
    user.name = "from nonparameter constructor built"
    user.age = -1
    return user
}

fun main() {
    val context = ClassPathXmlApplicationContext("classpath:bean.xml")
    context.beanDefinitionNames.forEach { name ->
        val bean = context.getBean(name)
        println("$name: $bean")
    }
}