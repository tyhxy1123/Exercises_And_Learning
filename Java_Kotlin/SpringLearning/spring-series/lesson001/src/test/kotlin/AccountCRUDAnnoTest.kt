import com.javacode2020.lesson000.JdbcConfig
import com.javacode2020.lesson000.account_annoioc.config.SpringConfig
import com.javacode2020.lesson000.account_annoioc.domain.Account
import com.javacode2020.lesson000.account_annoioc.service.IAccountService
import com.javacode2020.lesson000.account_annoioc.service.impl.AccountServiceImpl
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@ContextConfiguration(classes = [SpringConfig::class])
class AccountCRUDAnnoTest {
    @Autowired
    private lateinit var service:IAccountService

    @Test
    fun findAllTest(){
        println(service.findAllAccounts())
    }
    @Test
    fun findOneTest(){
        println(service.findAccountById(1))
        println(service.findAccountById(3))
        println(service.findAccountById(4))
    }
//
//    @Test
//    fun updateTest(){
//        val account = Account()
//        account.id=1
//        account.money=50000000.0f
//        account.name="张三"
//        service.updateAccount(account)
//        println(service.findAllAccounts())
//    }
//
//    @Test
//    fun saveTest(){
//        val account = Account()
//        account.id=6
//        account.money=20000000.0f
//        account.name="李四"
//        service.saveAccount(account)
//        println(service.findAllAccounts())
//    }
//    @Test
//    fun deleteTest(){
//        service.deleteAccount(2)
//        println(service.findAllAccounts())
//    }

    @Test
    fun transferTest(){
        service.transfer("张三","李四",100f)
        println(service.findAllAccounts())
    }

    @Test
    fun threadLocalEmptyTest(){
        val tl = ThreadLocal<Int>()
        println(tl.get()==null)
    }
}