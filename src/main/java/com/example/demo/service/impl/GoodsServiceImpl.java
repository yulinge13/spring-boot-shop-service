package com.example.demo.service.impl;

import com.example.demo.entity.ClassLists;
import com.example.demo.entity.FirstClass;
import com.example.demo.entity.Goods;
import com.example.demo.entity.MenuLists;
import com.example.demo.mapper.GoodsMapper;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    //实例化商品的mapper
    @Autowired
    private GoodsMapper goodsMapper;

    //所有商品
    @Override
    public List<Goods> findAll() {
        return goodsMapper.findAll();
    }

    //查询单个
    @Override
    public Goods findOne(String id) {
        Goods goodInfo = goodsMapper.findOne(id);
        return goodInfo;
    }

    @Override
    public Integer upDateOne(Goods goodInfo) {
        try {
            return goodsMapper.upDateOne(goodInfo);
        }catch (Exception e){
           e.printStackTrace();
            return 0;
        }
    }

    //路由菜单
    @Override
    public List<MenuLists> findAllMenuLists(){
        return  goodsMapper.findAllMenuLists();
    }
    //查询所有的一级分类
    @Override
    public List<FirstClass> getFirstClass() {
        return goodsMapper.getFirstClass();
    }
    //获取分类
    @Override
    public List<ClassLists> getClassLists(Integer firstClassId) {
        System.out.println("firstClassId"+firstClassId);
        return goodsMapper.getClassLists(firstClassId);
    }


}
