package com.example.demo.service;


import com.example.demo.entity.OrderEntity;

public interface OrderService extends BaseService<OrderEntity>{
    //下订单
    OrderEntity addOrder(OrderEntity orderInfo);
}
