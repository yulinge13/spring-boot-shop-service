package com.example.demo.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.OrderEntity;
import com.example.demo.entity.ResultMessage;
import com.example.demo.helper.JwtUtil;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class OrderControll {
    @Autowired
    OrderService orderService;

    JwtUtil jwtUtil = new JwtUtil();
    ResultMessage resultMessage = new ResultMessage();
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public Object addOrder(@RequestHeader(value = "token") String token, @RequestParam(value = "productId") String productId){
        try {
            if(productId == null || productId == ""){
                Object res =  resultMessage.failData(null,"获取失败");
                return res;
            }else{
                OrderEntity orderInfo = new OrderEntity();
                Integer userId = jwtUtil.getUserId(token);
                orderInfo.setUserId(userId);
                orderInfo.setProductId(productId);
                OrderEntity orderEntity = orderService.addOrder(orderInfo);
                System.out.println("orderEntity"+orderEntity);
                Object res =  resultMessage.successData(orderEntity,"下订单成功");
                return res;
            }
        }catch (Exception e){
            Object res =  resultMessage.failData(null,"下订单失败");
            return res;
        }
    }
}
