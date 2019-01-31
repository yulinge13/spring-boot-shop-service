package com.example.demo.controller;

import com.example.demo.entity.ResultMessage;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class User {
    @Autowired
    UserService userService;
    //用户登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestParam(value = "name",defaultValue = "") String name,@RequestParam(value = "passWord",defaultValue = "") String passWord){
        ResultMessage resultMessage = new ResultMessage();
        if("".equals(name) || "".equals(passWord)){
            Object res =  resultMessage.failData(null,"登录失败,请输入账号密码");
            return res;
        }else{
            try {
                Object res =  resultMessage.successData(userService.login(name,passWord),"登陆成功");
                return res;
            }catch (Exception e){
                System.out.println("e"+e);
                Object res =  resultMessage.failData(null,"登录失败");
                return res;
            }
        }
    }
    //注册
    public Object addUserInfo(@RequestParam(value = "name", defaultValue = "") String name,
                            @RequestParam(value = "passWord",defaultValue = "") String passWord,
                            @RequestParam(value = "sex",defaultValue = "") String sex,
                            @RequestParam(value = "age",defaultValue = "") String age){
        ResultMessage resultMessage = new ResultMessage();
        if(name == "" || passWord=="" || sex=="" || age==""){
            Object res =  resultMessage.failData(null,"登录失败,请输入账号密码");
            return res;
        }else{
            Object res =  resultMessage.failData(null,"登录失败,请输入账号密码");
            return res;
        }

    }
}
