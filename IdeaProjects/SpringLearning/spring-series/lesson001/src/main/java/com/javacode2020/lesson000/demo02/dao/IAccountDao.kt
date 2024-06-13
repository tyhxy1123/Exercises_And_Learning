package com.javacode2020.lesson000.demo02.dao

import com.javacode2020.lesson000.demo02.domain.Account

interface IAccountDao {
    fun findAllAccounts(): List<Account>
    fun findAccountById(id: Int): Account
    fun saveAccount(account: Account)
    fun updateAccount(account: Account)
    fun deleteAccount(accountId: Int)
}