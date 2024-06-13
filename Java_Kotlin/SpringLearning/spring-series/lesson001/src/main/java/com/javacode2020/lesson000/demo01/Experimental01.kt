package com.javacode2020.lesson000.demo01

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

//@ComponentScan(value=["com.javacode2020.lesson000"])
//@Configuration
@Service("exp")
open class Experimental01 {

    @Autowired
    @Qualifier("e01")
    var element01: IElement? = null

    @Autowired
    var e02: List<IElement>? = null

//    @Bean
//    fun getElement01():Element01{
//        return Element01()
//    }
//
//    @Bean
//    fun getElement02():Element02{
//        return Element02()
//    }


    override fun toString(): String {
        return "Experimental01(ele01=$element01, ele02=$e02)"
    }
}