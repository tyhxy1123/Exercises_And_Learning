package dynamicProxy.cglib

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ContextConfiguration(classes = [dynamicProxy.cglib.ProxyConfig::class])
class Test1 {
    @Autowired
    lateinit var cxt:ApplicationContext
    @Autowired
    lateinit var whole:List<Service1>
    @Test
    fun test1(){
        val a = cxt.getBean(Service1::class.java)
        a.m1()
        a.m2()
    }
}