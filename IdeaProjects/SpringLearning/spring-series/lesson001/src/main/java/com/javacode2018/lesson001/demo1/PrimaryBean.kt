package com.javacode2018.lesson001.demo1

class PrimaryBean {
    interface IService {}
    class Service1 : IService {}
    class Service2 : IService {}
    class Service3 : IService {}

    var beanList: List<IService>?

    constructor(injectedList: List<IService>) {
        this.beanList = injectedList
    }

    constructor() {
        this.beanList = ArrayList<IService>()
    }

    override fun toString(): String {
        return "PrimaryBean(beanList=$beanList)"
    }


}