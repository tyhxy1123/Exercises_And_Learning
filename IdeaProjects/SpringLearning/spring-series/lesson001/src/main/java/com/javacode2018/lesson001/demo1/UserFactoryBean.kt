package com.javacode2018.lesson001.demo1

import org.springframework.beans.factory.FactoryBean
import org.springframework.context.support.ClassPathXmlApplicationContext

class UserFactoryBean : FactoryBean<UserModel> {
    var count = 1
    override fun getObject(): UserModel? {
        val u = UserModel("我是通过factory bean创建的第$count 个对象", 30)
        count++
        return u
    }

    override fun getObjectType(): Class<*>? {
        return UserModel::class.java
    }

    override fun isSingleton(): Boolean {
        return false
    }
}

fun main() {
    val beanXml = "classpath:bean.xml"
    val context = ClassPathXmlApplicationContext(beanXml)
    context.beanDefinitionNames.forEach { beanName ->
        val bean = context.getBean(beanName)
        println("bean: $beanName, $bean")
    }
    println("createByFactoryBean: " + context.getBean("createByFactoryBean"))
    println("createByFactoryBean: " + context.getBean("createByFactoryBean"))
}