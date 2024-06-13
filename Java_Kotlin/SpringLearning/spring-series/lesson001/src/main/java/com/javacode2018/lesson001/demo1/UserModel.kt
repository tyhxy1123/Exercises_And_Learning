package com.javacode2018.lesson001.demo1

import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.lang.Nullable

class UserModel {
    var name: String
    var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    constructor() {
        this.name = "this name is created by default constructor"
        age = -1
    }

    fun say() {
        println("This a UserModel bean, name is: $name, age is: $age")
    }

    override fun toString(): String {
        return "UserModel(name='$name', age=$age)"
    }


}

fun main() {
    val beanXml = "classpath:bean.xml"
    val context = ClassPathXmlApplicationContext(beanXml)
    context.beanDefinitionNames.forEach { name ->
        println("$name: $context.getBean(name)")
    }
}