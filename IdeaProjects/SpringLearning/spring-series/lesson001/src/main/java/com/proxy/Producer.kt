package com.proxy

import java.lang.reflect.Proxy

class Producer:IProducer {
    fun test(){

    }

    override fun saleProduct(money: Float) {
        println("sold product, get money: $money")
    }
}