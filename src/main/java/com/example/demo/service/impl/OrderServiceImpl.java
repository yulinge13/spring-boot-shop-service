package com.example.demo.service.impl;

import com.example.demo.entity.Goods;
import com.example.demo.entity.OrderEntity;
import com.example.demo.helper.GetUuid;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.service.GoodsService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GetUuid getUuid;

    @Autowired
    GoodsService goodsService;
    private final String key = "ylgShop";
    //下订单
    @Override
    public OrderEntity addOrder(OrderEntity orderInfo) {
        try {
            String productId = orderInfo.getProductId();
            Goods goodInfo = goodsService.findOne(productId);
            if(goodInfo.getProductNum() != null && goodInfo.getProductNum()>=1){
                String orderId = getUuid.getUUID(1);
                String creatTime = String.valueOf(new Date().getTime());
                String orderNo = key+creatTime+ String.valueOf(Math.random()*10000);
                orderInfo.setOrderId(orderId);
                orderInfo.setCreatTime(creatTime);
                orderInfo.setOrderNo(orderNo);
                orderInfo.setOrderStatus(0);
                int orderEntityInfo = orderMapper.addOrder(orderInfo);
                System.out.println("orderEntityInfo"+orderEntityInfo);
                if(orderEntityInfo > 0 ){
                    Integer prodcutNum = goodInfo.getProductNum();
                    goodInfo.setProductNum(prodcutNum--);
                    goodsService.upDateOne(goodInfo);
                }
                return orderInfo;
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }
    //获取所有的订单
    @Override
    public List<OrderEntity> findAll() {
        return null;
    }
    //查询单个订单
    @Override
    public OrderEntity findOne(String id) {
        return null;
    }

    @Override
    public Integer upDateOne(OrderEntity orderEntity) {
        return null;
    }
}
