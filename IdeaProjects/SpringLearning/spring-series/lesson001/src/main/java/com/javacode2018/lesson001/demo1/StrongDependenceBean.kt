package com.javacode2018.lesson001.demo1

import org.springframework.beans.factory.DisposableBean

class StrongDependenceBean {
    class Bean1 : DisposableBean {
        constructor() {
            println(this.javaClass.toString() + " constructor!")
        }

        override fun destroy() {
            println(this.javaClass.toString() + " destroy()")
        }
    }

    class Bean2 : DisposableBean {
        val bean1: Bean1

        constructor(bean1: Bean1) {
            this.bean1 = bean1
            println(this.javaClass.toString() + " constructor!")
        }

        override fun destroy() {
            println(this.javaClass.toString() + " destroy()")
        }
    }

    class Bean3 : DisposableBean {
        val bean2: Bean2

        constructor(bean2: Bean2) {
            this.bean2 = bean2
            println(this.javaClass.toString() + " constructor!")
        }


        override fun destroy() {
            println(this.javaClass.toString() + " destroy()")
        }
    }
}