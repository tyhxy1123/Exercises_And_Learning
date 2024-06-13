package com.javacode2018.chat03.demo01;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class UserMapperTest {
    private SqlSessionFactory sessionFactory;

    @Before
    public void init() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        this.sessionFactory = new SqlSessionFactoryBuilder().build(stream);
    }

    @Test
    public void getUserList(){
        try(var session = sessionFactory.openSession()){
            UserMapper mapper = session.getMapper(UserMapper.class);
            var result = mapper.getUserList();
            result.forEach(item->{
                    log.info("{}", item);
                }
            );
        }
    }
}
