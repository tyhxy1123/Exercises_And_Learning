package com.javacode2020.lesson000.demo02.service.impl

import com.javacode2020.lesson000.demo02.dao.IAccountDao
import com.javacode2020.lesson000.demo02.domain.Account
import com.javacode2020.lesson000.demo02.service.IAccountService

class AccountServiceImpl:IAccountService {
    var accountDao: IAccountDao? = null
    override fun findAllAccounts(): List<Account> {
        return accountDao!!.findAllAccounts()
    }

    override fun findAccountById(id: Int): Account {
        return accountDao!!.findAccountById(id)
    }

    override fun saveAccount(account: Account) {
        accountDao!!.saveAccount(account)
    }

    override fun updateAccount(account: Account) {
        accountDao!!.updateAccount(account)
    }

    override fun deleteAccount(accountId: Int) {
        accountDao!!.deleteAccount(accountId)
    }
}