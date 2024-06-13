package com.javacode2020.lesson000.account_annoioc.dao.impl

import com.javacode2020.lesson000.account_annoioc.dao.IAccountDao
import com.javacode2020.lesson000.account_annoioc.domain.Account
import com.javacode2020.lesson000.account_annoioc.utils.ConnectionUtils
import org.apache.commons.dbutils.QueryRunner
import org.apache.commons.dbutils.handlers.BeanHandler
import org.apache.commons.dbutils.handlers.BeanListHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.lang.RuntimeException

@Repository("accountDao")
class AccountDaoImpl(private val runner:QueryRunner, private val connectionUtils:ConnectionUtils):IAccountDao {

    override fun findAllAccounts(): List<Account> {
        return runner.query(connectionUtils.getThreadConnection(),"select * from account", BeanListHandler<Account>(Account::class.java))
    }

    override fun findAccountById(id: Int): Account {
        return runner.query(connectionUtils.getThreadConnection(),"select * from account where id = ? ", BeanHandler<Account>(Account::class.java), id)
    }

    override fun saveAccount(account: Account) {
        runner.update(connectionUtils.getThreadConnection(),"insert into account(name,money)values(?,?)", account.name, account.money)
    }

    override fun updateAccount(account: Account) {
        runner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id=?", account.name, account.money, account.id)
    }

    override fun deleteAccount(accountId: Int) {
        runner.update(connectionUtils.getThreadConnection(),"delete from account where id=?",accountId)
    }

    override fun findAccountByName(accountName: String):Account? {
        try {
            val accounts = runner.query(connectionUtils.getThreadConnection(),"select * from account where name=?", BeanListHandler<Account>(Account::class.java), accountName)
            if (accounts == null || accounts.size == 0) {
                return null
            } else if (accounts.size > 1) {
                throw RuntimeException("结果集不唯一，数据有问题")
            } else {
                return accounts[0]
            }
        } catch(e:Exception){
            throw RuntimeException(e)
        }
    }
}