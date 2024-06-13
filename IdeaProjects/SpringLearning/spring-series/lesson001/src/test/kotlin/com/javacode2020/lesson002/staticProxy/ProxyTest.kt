package com.javacode2020.lesson002.staticProxy

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ContextConfiguration(classes = [com.javacode2020.lesson002.staticProxy.serviceConfig::class])
class ProxyTest {
    @Autowired
    lateinit var cxt:ApplicationContext

    @Test
    fun m1(){
        val serviceA:IService = cxt.getBean("proxyA", com.javacode2020.lesson002.staticProxy.ServiceProxy::class.java)
        val serviceB:IService = cxt.getBean("proxyB", com.javacode2020.lesson002.staticProxy.ServiceProxy::class.java)

        serviceA.m1()
        serviceA.m2()
        serviceA.m3()

        serviceB.m1()
        serviceB.m2()
        serviceB.m3()
    }


}