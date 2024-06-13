package com.javacode2018.chat04.demo1.mapper

import com.javacode2018.chat04.demo1.model.UserModel

interface UserMapper {
    fun insertUser(user:UserModel):Int
    fun updateUser(user:UserModel):Long
    fun deleteUser(user:UserModel):Boolean
    fun insertUser1(user:UserModel):Int
    fun insertUser2(user:UserModel):Int
}