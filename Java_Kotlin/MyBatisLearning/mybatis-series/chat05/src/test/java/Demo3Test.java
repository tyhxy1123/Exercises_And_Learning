import com.javacode2018.chat05.demo3.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class Demo3Test {
    private SqlSessionFactory sessiongFactory;

    @Before
    public void init() throws IOException {
        this.sessiongFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("demo3/mybatis-config.xml"));
    }

    @Test
    public void getById1(){
        var id = 1;
        var orderModel = sessiongFactory.openSession(true).getMapper(OrderMapper.class).getById1(id);
        System.out.println(orderModel);
    }
}
