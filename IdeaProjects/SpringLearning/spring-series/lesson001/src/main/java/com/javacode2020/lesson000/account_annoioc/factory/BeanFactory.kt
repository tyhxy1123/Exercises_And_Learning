package com.javacode2020.lesson000.account_annoioc.factory

import com.javacode2020.lesson000.account_annoioc.service.IAccountService
import com.javacode2020.lesson000.account_annoioc.utils.TransactionManager
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

class BeanFactory(private val txManager: TransactionManager, private val accountService: IAccountService) {
    fun getAccountService_OLD(): IAccountService {
        return Proxy.newProxyInstance(accountService.javaClass.classLoader, accountService.javaClass.interfaces, object : InvocationHandler {
            override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
                try {
                    txManager.beginTransaction()
                    val returnVal = if (args == null) method!!.invoke(accountService) else method!!.invoke(accountService, *args)
                    txManager.commit()
                    return returnVal
                } catch (e: Exception) {
                    txManager.rollback()
                    e.printStackTrace()
                    throw RuntimeException(e)
                } finally {
                    txManager.release()
                }
            }
        }) as IAccountService
    }

    fun getAccountService(): IAccountService {
        return Proxy.newProxyInstance(accountService.javaClass.classLoader, accountService.javaClass.interfaces) { _, method, args ->
            try {
                txManager.beginTransaction()
                val returnVal = if (args == null) method!!.invoke(accountService) else method!!.invoke(accountService, *args)
                txManager.commit()
                returnVal
            } catch (e: Exception) {
                txManager.rollback()
                e.printStackTrace()
                throw RuntimeException(e)
            } finally {
                txManager.release()
            }
        } as IAccountService
    }

}

interface Demo {
    fun hello(name: String, id: Int)
    fun hello1()
}

class Demo01 : Demo {
    override fun hello(name: String, id: Int) {
        println("hello $name! and $id")
    }

    override fun hello1() {
        println("hello")
    }
}

fun main() {
    val demo01 = Demo01()
    val c = Demo01::class.java.methods[0]
    val demoProxy: Demo = Proxy.newProxyInstance(Demo01::class.java.classLoader, Demo01::class.java.interfaces, object : InvocationHandler {
        override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
            println("Vorstecken von Funktion")
            val returnVal = if (args == null) method!!.invoke(demo01) else method!!.invoke(demo01, *args)
            println("Nachstecken von Funktion")
            return returnVal
        }
    }) as Demo
    demoProxy.hello("gogo", 1)
    demoProxy.hello1()
}