package com.javacode2018.chat04.demo1.model

class UserModel{
    var id:Long? = null
    var name:String? = null
    var age:Int? = null
    var salary:Double? = null
    var sex:Int? = null

    constructor(id: Long?, name: String?, age: Int?, salary: Double?, sex: Int?) {
        this.id = id
        this.name = name
        this.age = age
        this.salary = salary
        this.sex = sex
    }

    constructor()

    override fun toString(): String {
        return "UserModel(id=$id, name=$name, age=$age, salary=$salary, sex=$sex)"
    }


}