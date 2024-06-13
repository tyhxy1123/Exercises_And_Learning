package com.javacode2018.chat02;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class UserTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void sqlSession(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession();
        log.info("{}",sqlSession);
    }

    @Test
    public void insertUser(){
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession(false)){
            UserModel userModel = UserModel.builder().name("张三").age(45).salary(50000D).sex(1).build();
            int result = sqlSession.insert("com.javacode2018.chat02.UserMapper.insertUser", userModel);
            log.info("插入影响行数: {}", result);
            sqlSession.commit();
        }
    }

    @Test
    public void updateUser(){
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession(true)){
            var userModel = UserModel.builder().id(2L).name("李四").age(18).salary(2500D).sex(1).build();
            int result = sqlSession.update("com.javacode2018.chat02.UserMapper.updateUser", userModel);
            log.info("影响行数: {}", result);
        }
    }

    @Test
    public void deleteUser(){
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession(true)){
            UserModel userModel = UserModel.builder().id(1L).build();
            int result = sqlSession.delete("com.javacode2018.chat02.UserMapper.deleteUser", userModel);
            log.info("影响行数: {}", result);
        }
    }

    @Test
    public void getUserList(){
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession(false)){
            List<UserModel> userModels = sqlSession.selectList("com.javacode2018.chat02.UserMapper.getUserList");
            log.info("结果: {}", userModels);
        }
    }

    @Test
    public void insertWithUserMapper(){
        try(SqlSession sqlSession = this.sqlSessionFactory.openSession(true)){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            UserModel userModel = UserModel.builder().name("Phillip").sex(1).salary(5600D).age(23).build();
            int result = mapper.insertUser(userModel);
            log.info("影响行数: {}", result);
        }
    }

    @Test
    public void updateWithUserMapper(){
        try(var sqlSession = this.sqlSessionFactory.openSession(true)){
            var userModel = UserModel.builder().id(15L).name("Eva").age(18).sex(2).salary(6500D).build();
            var mapper = sqlSession.getMapper(UserMapper.class);
            int result = mapper.updateUser(userModel);
            log.info("影响行数: {}", result);
        }
    }

    @Test
    public void deleteWithUserMapper(){
        try(var sqlSession = this.sqlSessionFactory.openSession(true)){
            var userModel = UserModel.builder().id(2L).build();
            var mapper = sqlSession.getMapper(UserMapper.class);
            int result = mapper.deleteUser(userModel);
            log.info("影响行数: {}", result);
        }
    }

    @Test
    public void getUserListWithUserMapper(){
        try(var sqlSession = this.sqlSessionFactory.openSession(true)){
            var mapper = sqlSession.getMapper(UserMapper.class);
            var users = mapper.getUserList();
            log.info("users: {}", users);
        }
    }

}
