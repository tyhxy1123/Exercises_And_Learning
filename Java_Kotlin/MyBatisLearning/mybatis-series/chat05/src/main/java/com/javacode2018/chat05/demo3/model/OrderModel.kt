package com.javacode2018.chat05.demo3.model


class OrderModel {
    var id:Int? = null
    var userId:Int? = null
    var createTime:Long? = null
    var upTime:Long? = null

    var orderDetailModelList:List<OrderDetailModel>? = null
    override fun toString(): String {
        return "OrderModel(id=$id, userId=$userId, createTime=$createTime, upTime=$upTime, orderDetailModelList=$orderDetailModelList)"
    }


}