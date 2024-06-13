package com.javacode2018.lesson001.demo1

class PersonModel {
    var userModel: UserModel
    var carModel: CarModel

    constructor(userModel: UserModel, carModel: CarModel) {
        this.userModel = userModel
        this.carModel = carModel
    }

    constructor() {
        this.userModel = UserModel()
        this.carModel = CarModel("default", "default")
    }

    override fun toString(): String {
        return "PersonModel(userModel=$userModel, carModel=$carModel)"
    }


}