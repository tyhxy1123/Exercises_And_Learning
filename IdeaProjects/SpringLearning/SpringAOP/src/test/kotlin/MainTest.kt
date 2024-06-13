import com.service.IAccountService
import com.utils.Logger
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ContextConfiguration(locations = ["classpath:bean.xml"])
class MainTest() {
    @Autowired
    lateinit var accountService:IAccountService
    @Autowired
    lateinit var logger: Logger

    @Test
    fun f1(){
        logger.printLog()
    }

}