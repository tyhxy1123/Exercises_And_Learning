import com.javacode2018.chat05.demo1.mapper.OrderMapper
import lombok.extern.slf4j.Slf4j
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.Test
import kotlin.system.exitProcess

@Slf4j
class Demo1Test {
    val sessionFactory = SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("demo1/mybatis-config.xml"))

    @Test
    fun getById(){
        try {
            val id:Int = 1
            println("取出结果: "+sessionFactory.openSession(true).getMapper(OrderMapper::class.java).getById(id))
        }catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        }
    }

    @Test
    fun getById1(){
        try{
            val id:Int = 2
            println("取出结果: " + sessionFactory.openSession(true).getMapper(OrderMapper::class.java).getById1(id))
        }catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        }
    }

    @Test
    fun getById2(){
        try{
            val id:Int = 1
            println("取出结果: " + sessionFactory.openSession(true).getMapper(OrderMapper::class.java).getById2(id))
        } catch (e:Exception){
            e.printStackTrace()
            exitProcess(-1)
        }
    }


}