package dynamicProxy.cglib

import org.springframework.stereotype.Component

open class Service1 {
    fun m1(){
        println("我是m1方法")
    }
    fun m2(){
        println("我是m2方法")
    }
}