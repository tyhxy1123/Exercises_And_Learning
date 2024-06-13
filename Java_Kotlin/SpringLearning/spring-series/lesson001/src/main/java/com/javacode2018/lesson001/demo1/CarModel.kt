package com.javacode2018.lesson001.demo1

class CarModel {
    val name: String
    val desc: String

    constructor(p1: String, p2: String) {
        name = p1
        desc = p2
    }

    override fun toString(): String {
        return "CarModel(name='$name', desc='$desc')"
    }

}