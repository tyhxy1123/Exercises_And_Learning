package com.javacode2018.chat05.demo2.mapper

import com.javacode2018.chat05.demo2.model.UserModel

interface UserMapper {
    fun getById(id:Int):UserModel
    fun getById1(id:Int):UserModel
}