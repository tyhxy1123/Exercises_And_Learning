package com.javacode2020.lesson000.account_annoioc.utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.lang.RuntimeException
import java.sql.Connection
import javax.sql.DataSource

@Component
class ConnectionUtils(val dataSource:DataSource){
    val tl:ThreadLocal<Connection> = ThreadLocal<Connection>()

    fun getThreadConnection():Connection {
        var conn:Connection? = tl.get()
        try {
            if (conn == null) {
                conn = dataSource.getConnection()
                tl.set(conn)
                return conn
            }else{
                return conn
            }

        }catch (e:Exception){
            throw RuntimeException(e)
        }
    }

    fun removeConnection(){
        tl.remove()
    }

}