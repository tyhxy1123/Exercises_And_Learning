import com.javacode2018.chat05.demo2.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class Demo2Test {
    private SqlSessionFactory sessionFactory;

    @Before
    public void init() throws IOException {
        sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("demo2/mybatis-config.xml"));
    }

    @Test
    public void getById1(){
        var id = 1;
        log.info("{}", sessionFactory.openSession(true).getMapper(OrderMapper.class).getById1(id));
    }

    @Test
    public void getById2(){
        var id =1;
        log.info("{}", sessionFactory.openSession(true).getMapper(OrderMapper.class).getById2(id));
    }

    @Test
    public void getById3(){
        var id = 1;
        var mapper = sessionFactory.openSession(true).getMapper(OrderMapper.class);
        log.info("{}", mapper.getById3(id));
    }

    @Test
    public void getById4(){
        var id = 1;
        try{
            log.info("{}", sessionFactory.openSession(true).getMapper(OrderMapper.class).getById4(id));
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
