package com.javacode2018.chat02;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface UserMapper {
    int insertUser(UserModel userModel);
    int updateUser(UserModel userModel);
    int deleteUser(UserModel userModel);
    List<UserModel> getUserList();
}
