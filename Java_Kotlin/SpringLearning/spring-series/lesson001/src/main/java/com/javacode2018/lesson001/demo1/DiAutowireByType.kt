package com.javacode2018.lesson001.demo1

class DiAutowireByType {
    class Service1 {
        lateinit var desc: String
        override fun toString(): String {
            return "Service1(desc='$desc')"
        }

    }

    class Service2 {
        lateinit var desc: String
        override fun toString(): String {
            return "Service2(desc='$desc')"
        }

    }

    lateinit var service1: Service1
    lateinit var service2: Service2
    override fun toString(): String {
        return "DiAutowireByType(service1=$service1, service2=$service2)"
    }

}