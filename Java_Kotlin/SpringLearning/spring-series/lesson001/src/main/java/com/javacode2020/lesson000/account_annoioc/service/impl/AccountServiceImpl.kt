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
class AccountServiceImpl:IAccountService {
    @Autowired
    lateinit var accountDao: IAccountDao
    @Autowired
    lateinit var txManager:TransactionManager
    override fun findAllAccounts(): List<Account> {
        val accounts:List<Account>
        try{
            txManager.beginTransaction()
            accounts = accountDao.findAllAccounts()
            txManager.commit()
            return accounts
        }catch (e:Exception){
            txManager.rollback()
            throw RuntimeException(e)
        }finally {
            txManager.release()
        }
    }

    override fun findAccountById(id: Int): Account {
        val account:Account
        try{
            txManager.beginTransaction()
            account=accountDao.findAccountById(id)
            txManager.commit()
            return account
        }catch (e:Exception){
            txManager.rollback()
            throw RuntimeException(e)
        }finally {
            txManager.release()
        }

    }

    override fun saveAccount(account: Account) {
        val accounts:List<Account>
        try{
            txManager.beginTransaction()
            accountDao.saveAccount(account)
            txManager.commit()
        }catch (e:Exception){
            txManager.rollback()
            throw RuntimeException(e)
        }finally {
            txManager.release()
        }
    }

    override fun updateAccount(account: Account) {
        val accounts:List<Account>
        try{
            txManager.beginTransaction()
            accountDao.updateAccount(account)
            txManager.commit()
        }catch (e:Exception){
            txManager.rollback()
            throw RuntimeException(e)
        }finally {
            txManager.release()
        }
    }

    override fun deleteAccount(accountId: Int) {
        val accounts:List<Account>
        try{
            txManager.beginTransaction()
            accountDao.deleteAccount(accountId)
            txManager.commit()
        }catch (e:Exception){
            txManager.rollback()
            throw RuntimeException(e)
        }finally {
            txManager.release()
        }
    }

    override fun findAccountByName(accountName: String): Account? {
        val account:Account?
        try{
            txManager.beginTransaction()
            account=accountDao.findAccountByName(accountName)
            txManager.commit()
            return account
        }catch (e:Exception){
            txManager.rollback()
            throw RuntimeException(e)
        }finally {
            txManager.release()
        }
    }
    
    override fun transfer(sourceName: String, targetName: String, money: Float) {
        try{
            txManager.beginTransaction()
            val source = accountDao.findAccountByName(sourceName)
            val target = accountDao.findAccountByName(targetName)
            source!!.money=source.money!!.minus(money)
            target!!.money=target.money!!.plus(money)
            accountDao.updateAccount(source)
            accountDao.updateAccount(target)
            txManager.commit()
        }catch (e:Exception){
            txManager.rollback()
            throw RuntimeException(e)
        }finally {
            txManager.release()
        }
    }
}