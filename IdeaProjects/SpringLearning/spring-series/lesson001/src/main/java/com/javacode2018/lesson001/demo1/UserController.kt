package com.javacode2018.lesson001.demo1

class UserService {
    var userModel: UserModel = UserModel()
    fun insert(model: UserModel) {
        userModel = model
    }
}

class UserController(service: UserService) {
    val userService: UserService = service

    fun insert(model: UserModel) {
        userService.insert(model)
    }
}

fun main() {
    val context = context("bean.xml")

}