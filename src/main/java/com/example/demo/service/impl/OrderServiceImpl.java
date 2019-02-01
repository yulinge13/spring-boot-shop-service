package com.example.demo.service.impl;

import com.example.demo.entity.OrderEntity;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    //下订单
    @Override
    public OrderEntity addOrder(OrderEntity orderInfo) {
        try {
            orderMapper.addOrder(orderInfo);
            return orderInfo;
        }catch (Exception e){
            return null;
        }
    }
    //获取所有的订单
    @Override
    public List<OrderEntity> findAll() {
        return null;
    }
}
