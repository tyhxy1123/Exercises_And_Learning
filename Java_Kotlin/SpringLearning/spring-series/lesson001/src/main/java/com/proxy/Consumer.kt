package com.proxy

import java.lang.reflect.Proxy

class Consumer (private val producer:Producer) {
    fun consume(){
        val proxyProducer: IProducer = Proxy.newProxyInstance(producer.javaClass.classLoader, producer.javaClass.interfaces) { _, method, args ->
            var returnValue: Any? = null
            val money: Float = args!![0] as Float
            if (method!!.name == "saleProduct") {
                returnValue = method.invoke(producer, money.times(0.8f))
            }
            returnValue
        } as IProducer
        proxyProducer.saleProduct(10000f)
        producer.saleProduct(10000f)
    }
}

fun main(){
    val producer = Producer()
    val consumer = Consumer(producer)
    consumer.consume()
}