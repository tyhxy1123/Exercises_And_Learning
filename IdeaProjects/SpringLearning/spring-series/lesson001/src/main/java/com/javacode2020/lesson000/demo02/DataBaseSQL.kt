package com.javacode2020.lesson000.demo02

import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement


class DataBaseSQL {
    val JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"
    val DB_URL = "jdbc:mysql://localhost:3306/rookie?useSSL=false&serverTimezone=UTC"

    val USER = "root"
    val PASS = null

    fun createDataBase(){
        var conn: Connection? = null
        var stmt: Statement? = null

        Class.forName(JDBC_DRIVER)
        conn = DriverManager.getConnection(DB_URL,USER,PASS)
        stmt = conn.createStatement()

//        val sql = "select * from account"
//        stmt.execute(sql)
//        stmt.executeUpdate(sql)
//        println("Database created successfully...")

        stmt.close()
        conn.close()
    }
}