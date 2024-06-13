package com.javacode2020.lesson002.dynamicProxy;

public class UserService implements IUserService {
    @Override
    public void incert(String name) {
        System.out.println(String.format("用户[name: %s]插入成功", name));
    }
}
