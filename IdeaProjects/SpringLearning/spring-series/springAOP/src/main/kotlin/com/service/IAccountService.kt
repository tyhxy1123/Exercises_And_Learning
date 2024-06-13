package com.service

/**
 * 账户业务层接口
 */
interface IAccountService {
    fun savaAccount()

    fun updateAccount(i:Int)

    fun deleteAccount():Int
}