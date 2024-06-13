import com.javacode2018.chat04.demo1.mapper.UserMapper
import com.javacode2018.chat04.demo1.model.UserModel
import lombok.extern.slf4j.Slf4j
import org.apache.ibatis.io.Resources
import org.apache.ibatis.logging.Log
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.Test
import java.sql.*
import kotlin.Exception
import kotlin.system.exitProcess

@Slf4j
class Demo1Test {
    private val sessionFactory = SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("demo1/mybatis-config.xml"))
//    @Test
//    fun insertUser(){
//        var user: UserModel = UserModel(null,"Jan",14,5000.0,1)
//        try{
//            val mapper = sessionFactory.openSession(true).getMapper(UserMapper::class.java)
//            println("修改行数: "+mapper.insertUser(user))
//        }catch (e:Exception){
//            e.printStackTrace()
//            exitProcess(-1)
//        }
//    }

//    @Test
//    fun deleteUser(){
//        val user: UserModel = UserModel(25L, "Jan", null, null, null)
//        val mapper = sessionFactory.openSession(true).getMapper(UserMapper::class.java)
//        println(mapper.deleteUser(user))
//    }

//    @Test
//    fun updateUser(){
//        val user:UserModel = UserModel(1L, "John", 42, 54000.0, 1)
//        println("修改行数: " + sessionFactory.openSession(true).getMapper(UserMapper::class.java).updateUser(user))
//    }

    @Test
    fun jdbcInsertUser1():Unit{
        val jdbcDriver="com.mysql.cj.jdbc.Driver"
        val jdbcUrl="jdbc:mysql://localhost:3306/javacode2018?characterEncoding=UTF-8"
        val jdbcUsername="root"
        var connection: Connection? = null
        var preparedStatement:PreparedStatement? = null
        var generatedKeys: ResultSet? = null
        try{
            val userModel:UserModel = UserModel(null, "么么哒", 30, 50000.0,1)
            Class.forName(jdbcDriver)
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, null)
            preparedStatement = connection.prepareStatement("insert into t_user (name,age,salary,sex) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS)
            var parameterIndex:Int = 1
            preparedStatement.setString(parameterIndex++, userModel.name)
            preparedStatement.setInt(parameterIndex++, userModel.age!!)
            preparedStatement.setDouble(parameterIndex++, userModel.salary!!)
            preparedStatement.setInt(parameterIndex, userModel.sex!!)
            val count = preparedStatement.executeUpdate()
            println("修改行数: $count")

            generatedKeys = preparedStatement.generatedKeys
            if(generatedKeys != null && generatedKeys.next()){
                println("自增值为: " + generatedKeys.getInt(1))
            }

        } catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        } finally {
            if(generatedKeys != null && !generatedKeys.isClosed){
                generatedKeys.close()
            }
            if(preparedStatement != null && !preparedStatement.isClosed){
                preparedStatement.close()
            }
            if(connection != null && !connection.isClosed){
                connection.close()
            }
        }
    }

    @Test
    fun jdbcInsertUser2():Unit{
        val jdbcDriver="com.mysql.cj.jdbc.Driver"
        val jdbcUrl="jdbc:mysql://localhost:3306/javacode2018?characterEncoding=UTF-8"
        val jdbcUsername="root"
        var connection: Connection? = null
        var preparedStatement:PreparedStatement? = null
        var generatedKeys: ResultSet? = null
        try{
            val userModel:UserModel = UserModel(null, "么么哒", 30, 50000.0,1)
            Class.forName(jdbcDriver)
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, null)
            preparedStatement = connection.prepareStatement("insert into t_user (name,age,salary,sex) values(?,?,?,?)")
            var parameterIndex:Int = 1
            preparedStatement.setString(parameterIndex++, userModel.name)
            preparedStatement.setInt(parameterIndex++, userModel.age!!)
            preparedStatement.setDouble(parameterIndex++, userModel.salary!!)
            preparedStatement.setInt(parameterIndex++, userModel.sex!!)
            val count = preparedStatement.executeUpdate()
            println("修改行数: $count")

            val id = connection.prepareStatement("select LAST_INSERT_ID()").executeQuery()
            if(id != null && id.next()){
                println("自增值为: " + id.getInt(1))
            }

        } catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        } finally {
            if(generatedKeys != null && !generatedKeys.isClosed){
                generatedKeys.close()
            }
            if(preparedStatement != null && !preparedStatement.isClosed){
                preparedStatement.close()
            }
            if(connection != null && !connection.isClosed){
                connection.close()
            }
        }
    }

    @Test
    fun insertUser1(){
        val user = UserModel(null, "陈宝国", 56, 500000.0, 1)
        println(sessionFactory.openSession(true).getMapper(UserMapper::class.java).insertUser1(user))
        println(user)
    }

    @Test
    fun insertUser2(){
        val user = UserModel(null, "王五", 23, 2300.0, 1)
        println("修改行数: " + sessionFactory.openSession(true).getMapper(UserMapper::class.java).insertUser2(user))
        println(user)
    }
}