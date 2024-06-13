package com.javacode2018.chat05.demo3.model


class OrderDetailModel {
    private var id: Int? = null
    private var orderId: Int? = null
    private var goodsId: Int? = null
    private var num: Int? = null
    private var totalPrice: Double? = null
    override fun toString(): String {
        return "OrderDetailModel(id=$id, orderId=$orderId, goodsId=$goodsId, num=$num, totalPrice=$totalPrice)"
    }

}