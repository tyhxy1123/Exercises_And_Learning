package com.javacode2020.lesson002.dynamicProxy

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@ContextConfiguration(classes = [ConfigProxy::class])
class DynamicProxyTest {
    @Autowired
    lateinit var cxt:ApplicationContext

    @Test
    fun proxyServiceTest(){
        val serviceProxy: IService = cxt.getBean("serviceProxy", IService::class.java)
        serviceProxy.m1()
        serviceProxy.m2()
        serviceProxy.m3()
    }

    @Test
    fun proxyServiceEasyTest(){
        val serviceProxyEasy: IService = cxt.getBean("serviceProxyEasy", IService::class.java)
        serviceProxyEasy.m1()
        serviceProxyEasy.m2()
        serviceProxyEasy.m3()
    }

    @Test
    fun proxyServiceExampleTest(){
        val pa = cxt.getBean("exampleProxyA") as IService
        val pb = cxt.getBean("exampleProxyB") as IService
        pa.m1()
        pa.m2()
        pa.m3()
        pb.m1()
        pb.m2()
        pb.m3()
    }

    @Test
    fun userServiceProxyTest(){
        val service = cxt.getBean("userProxy", IUserService::class.java)
        service.incert("张三")
    }
}