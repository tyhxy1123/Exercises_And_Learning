package com.javacode2020.lesson000.account_annoioc.service.impl

import com.javacode2020.lesson000.account_annoioc.dao.IAccountDao
import com.javacode2020.lesson000.account_annoioc.domain.Account
import com.javacode2020.lesson000.account_annoioc.service.IAccountService
import com.javacode2020.lesson000.account_annoioc.utils.TransactionManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.lang.RuntimeException

@Service("accountService")
class AccountServiceImpl_OLD : IAccountService {
    @Autowired
    lateinit var accountDao: IAccountDao
    override fun findAllAccounts(): List<Account> {
        return accountDao.findAllAccounts()
    }

    override fun findAccountById(id: Int): Account {
        return accountDao.findAccountById(id)
    }

    override fun saveAccount(account: Account) {
        accountDao.saveAccount(account)
    }

    override fun updateAccount(account: Account) {
        accountDao.updateAccount(account)
    }

    override fun deleteAccount(accountId: Int) {
        accountDao.deleteAccount(accountId)
    }

    override fun findAccountByName(accountName: String): Account? {
        return accountDao.findAccountByName(accountName)
    }

    override fun transfer(sourceName: String, targetName: String, money: Float) {
        val source = accountDao.findAccountByName(sourceName)
        val target = accountDao.findAccountByName(targetName)
        source!!.money = source.money!!.minus(money)
        target!!.money = target.money!!.plus(money)
        accountDao.updateAccount(source)
        accountDao.updateAccount(target)
    }
}