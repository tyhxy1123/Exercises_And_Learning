package com.javacode2018.lesson001.demo1

import org.springframework.beans.factory.DisposableBean

class NormalBean {
    class Bean1 : DisposableBean {
        constructor() {
            println(this.javaClass.toString() + " constructor!")
        }

        override fun destroy() {
            println(this.javaClass.toString() + " destroy()")
        }
    }

    class Bean2 : DisposableBean {
        constructor() {
            println(this.javaClass.toString() + " constructor!")
        }

        override fun destroy() {
            println(this.javaClass.toString() + " destroy()")
        }
    }

    class Bean3 : DisposableBean {
        constructor() {
            println(this.javaClass.toString() + " constructor!")
        }

        override fun destroy() {
            println(this.javaClass.toString() + " destroy()")
        }
    }


}