import com.javacode2020.lesson000.account_annoioc.dao.IAccountDao
import com.javacode2020.lesson000.account_annoioc.dao.impl.AccountDaoImpl
import com.javacode2020.lesson000.account_annoioc.service.IAccountService
import com.javacode2020.lesson000.account_annoioc.domain.Account
import com.javacode2020.lesson000.account_annoioc.service.impl.AccountServiceImpl
import org.apache.commons.dbutils.QueryRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ContextConfiguration(locations = ["classpath:accountsCRUDBean.xml"])
class AccountCRUDTest {
    @Autowired
    @Qualifier("accountServiceProxy")
    private lateinit var service:IAccountService
    @Autowired
    private lateinit var runner:QueryRunner
    @Test
    fun init(){
        println(service.toString())
    }
    @Test
    fun findAllTest(){
        println(service.findAllAccounts())
    }
    @Test
    fun findOneTest(){
        println(service.findAccountById(1))

    }

    @Test
    fun updateTest(){
        val account = Account()
        account.id=1
        account.money=50000000.0f
        account.name="张三"
        service.updateAccount(account)
        println(service.findAllAccounts())
    }

    @Test
    fun saveTest(){
        val account = Account()
        account.id=6
        account.money=20000000.0f
        account.name="李四"
        service.saveAccount(account)
        println(service.findAllAccounts())
    }
    @Test
    fun deleteTest(){
        service.deleteAccount(2)
        println(service.findAllAccounts())
    }

    @Test
    fun transferTest(){
        service.transfer("张三","李四",100f)
        service.transfer("李四","张三",100f)
    }
}