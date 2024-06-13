package com.javacode2018.lesson001.demo1

class DiByAutowireTypeExtend {

    interface IService1 {}

    open class BaseService {
        lateinit var desc: String
        override fun toString(): String {
            return "BaseService(desc='$desc')"
        }
    }

    class Service1 : BaseService(), IService1 {}

    class Service2 : BaseService(), IService1 {}

    lateinit var mapIServices: Map<String, IService1>
    lateinit var mapBaseServices: Map<String, BaseService>
    lateinit var iServices: List<IService1>
    lateinit var baseServices: List<BaseService>
    override fun toString(): String {
        return "DiByAutowireTypeExtend(mapIServices=$mapIServices, \nmapBaseServices=$mapBaseServices, \niServices=$iServices, \nbaseServices=$baseServices)"
    }


}