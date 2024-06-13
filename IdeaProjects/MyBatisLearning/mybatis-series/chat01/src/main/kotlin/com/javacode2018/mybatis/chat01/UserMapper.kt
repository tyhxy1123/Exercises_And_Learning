package com.javacode2018.mybatis.chat01

interface UserMapper {
    fun insert(userModel:UserModel)
    fun insertBatch(userModelList:List<UserModel>)
    fun update(userModel: UserModel):Int
    fun updateByMap(map:Map<String,Any>)
    fun delete(map: Map<String, Any>):Int
    fun getModelList(map: Map<String, Any>):List<UserModel>
}