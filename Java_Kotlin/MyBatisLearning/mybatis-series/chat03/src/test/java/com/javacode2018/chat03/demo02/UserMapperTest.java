package com.javacode2018.chat03.demo02;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

@Slf4j
public class UserMapperTest {
    private SqlSessionFactory sessionFactory;
    @Before
    public void init() throws IOException {
        this.sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("demo02/mybatis-config.xml"));
    }

    @Test
    public void getUserList(){
        try(var session = sessionFactory.openSession(true)){
            var mapper = session.getMapper(UserMapper.class);
            var result = mapper.getUserList();
            result.forEach(item ->{log.info("{}", item);});
        }
    }
}
