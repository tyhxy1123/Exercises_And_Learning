package com.javacode2020.jdbc

import org.junit.Test
import java.sql.*

class JDBCTest {
    @Test
    fun initTest(){
        var conn:Connection? = null;
        var stmt:Statement? = null;
        var rs:ResultSet? = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", null)
            stmt = conn.createStatement()
            stmt.execute("use rookie")
            stmt.executeQuery("select * from account")
            rs = stmt.resultSet
            while(rs.next()){
                println(rs.getString("id"))
                println(rs.getInt("id"))
            }
        }catch (e:SQLException){
            e.printStackTrace()
        }catch (e:ClassNotFoundException){
            e.printStackTrace()
        }finally {
            try{
                rs!!.close()
                rs = null
                stmt!!.close()
                stmt = null
                conn!!.close()
                conn = null
            } catch (e:SQLException){
                e.printStackTrace()
            }
        }
    }
}