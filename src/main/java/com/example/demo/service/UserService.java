package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    //登陆
    Object login(String name,String passWord);
    //注册
    Boolean addUserInfo(User user);
}
