package com.javacode2020.lesson000.account_annoioc.service

import com.javacode2020.lesson000.account_annoioc.domain.Account

interface IAccountService {
    fun findAllAccounts(): List<Account>
    fun findAccountById(id: Int): Account
    fun saveAccount(account: Account)
    fun updateAccount(account: Account)
    fun deleteAccount(accountId: Int)
    fun findAccountByName(accountName:String):Account?
    fun transfer(sourceName:String, targetName:String,money:Float)
}