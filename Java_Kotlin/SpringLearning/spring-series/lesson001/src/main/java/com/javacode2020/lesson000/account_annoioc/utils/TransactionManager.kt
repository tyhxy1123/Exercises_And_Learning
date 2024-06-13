package com.javacode2020.lesson000.account_annoioc.utils

import org.springframework.stereotype.Component
import java.lang.Exception

/**
 * 开启事务，提交事务，回滚事务，释放连接
 */
@Component
class TransactionManager(val connectionUtils:ConnectionUtils) {

    /**
     * 开启事务
     */
    fun beginTransaction(){
        try {
            connectionUtils.getThreadConnection().autoCommit = false
        }catch(e:Exception){
            e.printStackTrace()
        }
    }

    /**
     * 提交事务
     */
    fun commit(){
        try {
            connectionUtils.getThreadConnection().commit()
        }catch(e:Exception){
            e.printStackTrace()
        }
    }

    /**
     * 回滚事务
     */
    fun rollback(){
        try {
            connectionUtils.getThreadConnection().rollback()
        }catch(e:Exception){
            e.printStackTrace()
        }
    }

    /**
     * 释放连接
     */
    fun release(){
        try {
            connectionUtils.getThreadConnection().close()
            connectionUtils.removeConnection()
        }catch(e:Exception){
            e.printStackTrace()
        }
    }
}