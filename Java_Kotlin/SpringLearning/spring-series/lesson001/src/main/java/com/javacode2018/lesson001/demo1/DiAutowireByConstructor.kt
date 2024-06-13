package com.javacode2018.lesson001.demo1

class DiAutowireByConstructor {
    var service1: Service1?
    var service2: Service2?

    constructor(service1: Service1) {
        println("DiAutowireByConstructor(service1:Service1)")
        this.service1 = service1
        this.service2 = null
    }

    constructor(service1: Service1, service2: Service2) {
        println("DiAutowireByConstructor(service1:Service1, service2:Service2)")
        this.service1 = service1
        this.service2 = service2
    }

    constructor() {
        this.service1 = null
        this.service2 = null
    }

    abstract class BaseService {
        lateinit var desc: String

        override fun toString(): String {
            return "BaseService(desc='$desc')"
        }
    }

    class Service1 : BaseService() {}
    class Service2 : BaseService() {}

    override fun toString(): String {
        return "DiAutowireByConstructor(service1=$service1, service2=$service2)"
    }
}