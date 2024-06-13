package com.javacode2018.lesson001.demo1

class ExtendBean {
    class ServiceA {
        var name: String? = null
        var desc: String? = null

        constructor(name: String?, desc: String?) {
            this.name = name
            this.desc = desc
        }

        constructor()

        override fun toString(): String {
            return "ServiceA(name=$name, desc=$desc)"
        }


    }

    class ServiceB {

        var name: String? = null
        var desc: String? = null

        constructor(name: String?, desc: String?) {
            this.name = name
            this.desc = desc
        }

        constructor()

        override fun toString(): String {
            return "ServiceB(name=$name, desc=$desc)"
        }

    }

    var serviceA: ServiceA? = null
    var serviceB: ServiceB? = null

    constructor(serviceA: ServiceA?, serviceB: ServiceB?) {
        this.serviceA = serviceA
        this.serviceB = serviceB
    }

    constructor(serviceA: ServiceA?) {
        this.serviceA = serviceA
    }

    constructor(serviceB: ServiceB?) {
        this.serviceB = serviceB
    }

    constructor()

    override fun toString(): String {
        return "ExtendBean(\nserviceA=$serviceA, \nserviceB=$serviceB)"
    }


}