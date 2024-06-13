package dynamicProxy.cglib

import org.springframework.cglib.proxy.Enhancer
import org.springframework.cglib.proxy.MethodInterceptor
import org.springframework.cglib.proxy.MethodProxy
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import java.lang.reflect.Method
import kotlin.reflect.cast

@Configuration
@ComponentScan
open class ProxyConfig {
    @Bean("proxy")
    open fun createProxy():Service1{
        val enhancer:Enhancer = Enhancer()
        enhancer.setSuperclass(Service1::class.java)
        enhancer.setCallback(MethodInterceptor{
            any, method, arrayOfAnys, methodProxy ->
            println("hello world")
            val result = methodProxy.invokeSuper(any, arrayOfAnys)
            println("over")
            result
        })
        return enhancer.create() as Service1
    }
//    @Bean("proxy2")
    fun createProxy2():Service1{
        val en = Enhancer()
        en.setSuperclass(Service1::class.java)
        en.setCallback(object:MethodInterceptor{
            override fun intercept(p0: Any?, p1: Method?, p2: Array<out Any>?, p3: MethodProxy?): Any {
                println("调用方法，通过生成Object from Interface: $p1")
                return p3!!.invokeSuper(p0, p2)
            }
        })
        return Service1::class.java.cast(en.create())
    }
}