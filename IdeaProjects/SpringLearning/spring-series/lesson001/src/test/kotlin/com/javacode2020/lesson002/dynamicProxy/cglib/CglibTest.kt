package com.javacode2020.lesson002.dynamicProxy.cglib

import com.javacode2020.lesson000.account_annoioc.factory.Demo
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cglib.proxy.Enhancer
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ContextConfiguration(classes = [ProxyConfig::class])
class CglibTest {
    @Autowired
    lateinit var cxt:ApplicationContext
    @Test
    fun test01(){
        val service1 = cxt.getBean("service1") as Service1
        service1.m1()
    }

    @Test
    fun fixedValueTest(){
        val fixedProxy:FixedValueProxy = cxt.getBean(FixedValueProxy::class.java)
        fixedProxy.service1.m1()
        fixedProxy.service1.m2()
    }

    @Test
    fun callBackFilterTest(){
        val proxy = cxt.getBean("proxy4") as Service4
        proxy.get1()
        proxy.get2()
        proxy.incert1()
        proxy.incert2()
    }

    @Test
    fun proxyCallBackHelperTest(){
        val proxy = cxt.getBean("proxyCallBackHelper") as Service4
        println("------------")
        proxy.incert1()
        println("------------")
        proxy.incert2()
        println("------------")
        println(proxy.get1())
        println("------------")
        println(proxy.get2())
    }


    open class DemoClassForAnyProxy{
        open fun m1(): Unit {
            println("this is m1")
        }
    }
    @Test
    fun proxyForAnyTest(){
        val d1 = DemoClassForAnyProxy()
        val fabrik:ProxyForAny = cxt.getBean("anyProxyFactory", ProxyForAny::class.java)
        val demo = fabrik.createProxy(DemoClassForAnyProxy())
        demo.m1()
    }

    @Test
    fun contextTest(){
        cxt.beanDefinitionNames.forEach {name ->
            println("bean name: $name, bean alias: ${cxt.getAliases(name)}, bean class: ${cxt.getBean(name)}")
        }
    }
}