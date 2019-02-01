package com.example.demo.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ResultMessage;
import com.example.demo.helper.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class OrderControll {

    JwtUtil jwtUtil = new JwtUtil();
    ResultMessage resultMessage = new ResultMessage();
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public Object addOrder(@RequestHeader(value = "token") String token, @RequestParam(value = "productId") String productId){
        System.out.println("productId"+productId);
        System.out.println("token"+token);
        if(productId == null || productId == ""){
            Object res =  resultMessage.failData(null,"获取失败");
            return res;
        }else{
            OrderEntity orderInfo = new OrderEntity();
            DecodedJWT userInfo = jwtUtil.getUserInfo(token);
            System.out.println("userInfo"+userInfo.getToken());
            return null;
        }
    }
}
