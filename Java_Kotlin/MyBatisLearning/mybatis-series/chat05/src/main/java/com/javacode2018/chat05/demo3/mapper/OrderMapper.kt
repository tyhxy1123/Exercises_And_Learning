package com.javacode2018.chat05.demo3.mapper

import com.javacode2018.chat05.demo3.model.OrderModel

interface OrderMapper {
    fun getById1(id:Int):OrderModel
}