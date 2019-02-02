package com.example.demo.service.impl;


import com.example.demo.entity.User;
import com.example.demo.helper.JwtUtil;
import com.example.demo.helper.Md5Utils;
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

    @Autowired
    Md5Utils md5Utils ;

    JwtUtil jwtUtil = new JwtUtil();

    @Override
    public Object login(String name,String passWord) {
        User user = new User();
        user.setName(name);
        user.setPassWord(passWord);
        User userInfo = userMapper.login(user);
        String token = jwtUtil.sign(userInfo.getId(),secret);
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        return map;
    }
    //注册
    @Override
    public Boolean addUserInfo(User user) {
        try {
            String Md5PassWord = md5Utils.getMd5Value(user.getPassWord());
            user.setPassWord(Md5PassWord);
            userMapper.addUserInfo(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String getSecret() {
        return secret;
    }
}
