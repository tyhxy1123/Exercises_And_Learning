package com.javacode2018.chat03.demo03;

import com.javacode2018.chat03.demo03.mapper.OrderMapper;
import com.javacode2018.chat03.demo03.mapper.UserMapper;
import com.javacode2018.chat03.demo03.model.OrderModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

@Slf4j
public class DoubleTest {
    private SqlSessionFactory sessionFactory;
    @Before
    public void init() throws IOException {
        sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("demo03/mybatis-config.xml"));
    }

    @Test
    public void getList(){
        OrderMapper orderMapper = sessionFactory.openSession().getMapper(OrderMapper.class);
        UserMapper userMapper = sessionFactory.openSession().getMapper(UserMapper.class);
        orderMapper.getList().forEach(item->log.info("{}",item));
        userMapper.getList().forEach(item->log.info("{}", item));
    }
}
