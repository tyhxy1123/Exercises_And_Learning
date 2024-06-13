package com.javacode2018.chat05.demo1.mapper

import com.javacode2018.chat05.demo1.model.OrderModel

interface OrderMapper {
    fun getById(id:Int):OrderModel
    fun getById1(id:Int):OrderModel
    fun getById2(id:Int):OrderModel
}