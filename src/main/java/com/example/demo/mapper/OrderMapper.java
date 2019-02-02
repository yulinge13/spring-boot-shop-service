package com.example.demo.mapper;

import com.example.demo.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderMapper {
    //下订单
    int addOrder(OrderEntity orderInfo);
}
