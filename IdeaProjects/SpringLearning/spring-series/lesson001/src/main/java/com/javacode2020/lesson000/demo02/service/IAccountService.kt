package com.javacode2020.lesson000.demo02.service

import com.javacode2020.lesson000.demo02.domain.Account

interface IAccountService {
    fun findAllAccounts(): List<Account>
    fun findAccountById(id: Int): Account
    fun saveAccount(account: Account)
    fun updateAccount(account: Account)
    fun deleteAccount(accountId: Int)
}