package com.javacode2018.chat03.demo01;

import java.util.List;

public interface UserMapper {
    public int insertUser(UserModel user);
    public int updateUser(UserModel user);
    public int deleteUser(Long userId);
    public List<UserModel> getUserList();
}
