package com.example.demo.helper;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
public class Md5Utils {
    //MD5加密
    public String getMd5Value(String password){
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        return md5Password;
    }
}
