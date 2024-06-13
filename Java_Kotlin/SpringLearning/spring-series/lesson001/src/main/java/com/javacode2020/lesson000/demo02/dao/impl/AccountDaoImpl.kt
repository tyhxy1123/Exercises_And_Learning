package com.javacode2020.lesson000.demo02.dao.impl

import com.javacode2020.lesson000.demo02.dao.IAccountDao
import com.javacode2020.lesson000.demo02.domain.Account
import org.apache.commons.dbutils.QueryRunner
import org.apache.commons.dbutils.handlers.BeanHandler
import org.apache.commons.dbutils.handlers.BeanListHandler

class AccountDaoImpl:IAccountDao {

    var runner: QueryRunner? = null
    override fun findAllAccounts(): List<Account> {
        return runner!!.query("select * from account", BeanListHandler<Account>(Account::class.java))
    }

    override fun findAccountById(id: Int): Account {
        return runner!!.query("select * from account where id = ? ", BeanHandler<Account>(Account::class.java), id)
    }

    override fun saveAccount(account: Account) {
        runner!!.update("insert into account(name,money)values(?,?)", account.name, account.money)
    }

    override fun updateAccount(account: Account) {
        runner!!.update("update account set name=?,money=? where id=?", account.name, account.money, account.id)
    }

    override fun deleteAccount(accountId: Int) {
        runner!!.update("delete from account where id=?",accountId)
    }
}