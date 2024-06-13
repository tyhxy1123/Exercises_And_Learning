package com.javacode2018.chat03.demo04

import com.javacode2018.chat03.demo04.mapper.UserMapper
import com.javacode2018.chat03.demo04.model.UserFindDto
import com.javacode2018.chat03.demo04.model.UserModel
import org.apache.ibatis.executor.result.DefaultResultContext
import org.apache.ibatis.executor.result.DefaultResultHandler
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactory
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.Test
import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

class Demo4Test {
    private val sessionFactory: SqlSessionFactory = SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("demo04/mybatis-config.xml"))

    @Test
    fun getByName(){
        var user:UserModel? = null
        try{
            user = sessionFactory.openSession(true).getMapper(UserMapper::class.java).getByName("张三")
            println(user)
        } catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        }
    }

    @Test
    fun getByMap(){
        val map:MutableMap<String,Any> = TreeMap()
        map["id"] = 14
        map["name"] = "张三"
        try{
            val users = sessionFactory.openSession(true).getMapper(UserMapper::class.java).getByMap(map)
            users.forEach { user->
                println(user)
            }
        } catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        }
    }

    @Test
    fun getListByUserFindDto(){
        val ufd = UserFindDto(14L, "张三")
        try{
            val users = sessionFactory.openSession(true).getMapper(UserMapper::class.java).getByUserFindDto(ufd)
            users.forEach { user->
                println(user)
            }
        } catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        }
    }

    @Test
    fun getByIdOrName(){
        val targetId = 15L
        val targetName = "Eva"
        try{
            val user = sessionFactory.openSession(true).getMapper(UserMapper::class.java).getByIdOrName(null,targetName)
            println(user)
        } catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        }
    }

    @Test
    fun getListByIdCollection(){
        val idList:List<Long> = listOf(13,14,15)
        try{
            val users = sessionFactory.openSession(true).getMapper(UserMapper::class.java).getListByIdCollection(idList)
            users.forEach { user->
                println(user)
            }
        } catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        }

    }

    @Test
    fun getListByIdList(){
        val idList:List<Long> = listOf(13,15)
        try{
            val users = sessionFactory.openSession(true).getMapper(UserMapper::class.java).getListByIdList(idList)
            users.forEach { user->
                println(user)
            }
        } catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        }
    }

    @Test
    fun getList(){
        try{
            val session = sessionFactory.openSession(true)
            val mapper:UserMapper = session.getMapper(UserMapper::class.java)
            mapper.getList{context->
                val defaultContext:DefaultResultContext<UserModel> = context as DefaultResultContext<UserModel>
                println(defaultContext.resultObject)
                if(defaultContext.resultCount == 2){
                    defaultContext.stop()
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        }


    }
}