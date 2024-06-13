import com.javacode2020.lesson000.demo01.Experimental01
import org.junit.Before
import org.junit.Test
import org.springframework.context.support.ClassPathXmlApplicationContext

class Test02 {

    @Before
    fun init(){

    }
    @Test
    fun testExp01() {

//        val context = AnnotationConfigApplicationContext(ComponentScan::class.java)
        val cxt = ClassPathXmlApplicationContext("experimentalBean.xml")
        val exp = cxt.getBean("exp", Experimental01::class.java)
        println(exp)

    }


}