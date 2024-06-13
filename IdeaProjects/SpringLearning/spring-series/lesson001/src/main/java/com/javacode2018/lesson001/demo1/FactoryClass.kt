package com.javacode2018.lesson001.demo1

class FactoryClass {
    fun buildUser1(): UserModel {
        val u = UserModel()
        u.name = "By buildUser1 from factory bean built"
        u.age = -1
        return u
    }

    fun buildUser1(name: String, age: Int): UserModel {
        val u = UserModel()
        u.name = name
        u.age = age
        return u
    }
}