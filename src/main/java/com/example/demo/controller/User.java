package com.example.demo.controller;

import com.example.demo.entity.ResultMessage;
import com.example.demo.helper.Md5Utils;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class User {
    @Autowired
    UserService userService;

    @Autowired
    Md5Utils md5Utils;
    //用户登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestParam(value = "name",defaultValue = "") String name,@RequestParam(value = "passWord",defaultValue = "") String passWord){
        ResultMessage resultMessage = new ResultMessage();
        if("".equals(name) || "".equals(passWord)){
            Object res =  resultMessage.failData(null,"登录失败,请输入账号密码");
            return res;
        }else{
            try {
                passWord = md5Utils.getMd5Value(passWord);
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
    @RequestMapping(value = "addUserInfo",method = RequestMethod.POST)
    public Object addUserInfo(@RequestParam(value = "name", defaultValue = "") String name,
                            @RequestParam(value = "passWord",defaultValue = "") String passWord,
                            @RequestParam(value = "sex",defaultValue = "") Integer sex,
                            @RequestParam(value = "age",defaultValue = "") Integer age){
        ResultMessage resultMessage = new ResultMessage();
        if(name == "" || passWord=="" ){
            Object res =  resultMessage.failData(null,"注册失败");
            return res;
        }else{
            try {
                com.example.demo.entity.User userInfo = new com.example.demo.entity.User();
                userInfo.setPassWord(passWord);
                userInfo.setName(name);
                userInfo.setAge(age);
                userInfo.setSex(sex);
                Boolean isADDSuccess = userService.addUserInfo(userInfo);
                if(isADDSuccess == true){
                    Object res =  resultMessage.successData(userService.addUserInfo(userInfo),"注册成功");
                    return res;
                }else{
                    Object res =  resultMessage.failData(userService.addUserInfo(userInfo),"注册失败");
                    return res;
                }
            }catch (Exception e){
                Object res =  resultMessage.failData(null,"注册失败");
                return res;
            }
        }

    }
}
