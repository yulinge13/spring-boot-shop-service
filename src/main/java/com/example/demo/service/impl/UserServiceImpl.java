package com.example.demo.service.impl;


import com.example.demo.entity.User;
import com.example.demo.helper.JwtUtil;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    protected final String secret = "yulinge";

    @Autowired
    UserMapper userMapper;

    JwtUtil jwtUtil = new JwtUtil();

    @Override
    public Object login(String name,String passWord) {
        User user = new User();
        user.setName(name);
        user.setPassWord(passWord);
        User userInfo = userMapper.login(user);
        String token = jwtUtil.sign(userInfo.getName(),secret);
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return map;
    }
}
