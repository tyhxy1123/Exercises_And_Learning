package dynamicProxy.cglib

import org.springframework.cglib.proxy.Enhancer
import org.springframework.cglib.proxy.MethodInterceptor
import org.springframework.cglib.proxy.MethodProxy
import java.lang.reflect.Method

open class Service2 {
    fun m1(){
        println("go go")
    }
}

class BigMethodIntcetper:MethodInterceptor{
    override fun intercept(p0: Any?, p1: Method?, p2: Array<out Any>?, p3: MethodProxy?): Any {
        println("Hello World")
        val result = p3!!.invokeSuper(p0, p2)
        println("over")
        return result
    }
}

fun main(){
    val en: Enhancer = Enhancer()
    en.setSuperclass(Service2::class.java)
    en.setCallback(BigMethodIntcetper())
    val a:Service2 = Service2::class.java.cast(en.create())
    a.m1()

}