package com.javacode2018.lesson001.demo1

class LazyInitBean {
    class DiligentBean {
        init {
            println("我是勤奋Bean!我一开始就把一切加载好了")
        }
    }

    init {
        println("我是懒加载Bean!我很懒所以我到用时才初始化")
    }
}