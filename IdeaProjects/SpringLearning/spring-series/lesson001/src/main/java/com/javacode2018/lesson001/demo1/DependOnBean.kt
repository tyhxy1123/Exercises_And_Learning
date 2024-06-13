package com.javacode2018.lesson001.demo1

import org.springframework.beans.factory.DisposableBean

class DependOnBean {

    abstract class BigBean : DisposableBean {
        init {
            println(this.javaClass.toString() + " constructor!")
        }

        override fun destroy() {
            println(this.javaClass.toString() + " destroy()")
        }
    }

    class Bean1 : BigBean() {}
    class Bean2 : BigBean() {}
    class Bean3 : BigBean() {}
    class Bean4 : BigBean() {}
}