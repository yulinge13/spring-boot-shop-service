package com.example.demo.mapper;


import com.example.demo.entity.ClassLists;
import com.example.demo.entity.FirstClass;
import com.example.demo.entity.Goods;
import com.example.demo.entity.MenuLists;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GoodsMapper {
    List<Goods> findAll();//获取所有商品
    List<MenuLists> findAllMenuLists(); //获取所有的路由菜单
    List<FirstClass> getFirstClass(); //查询所有的一级分类
    List<ClassLists> getClassLists(@Param("firstClassId") Integer firstClassId); //获取分类
    Goods findOne(@Param("productId") String productId);//查询单个
    int upDateOne(Goods goods);//单个数据更新
}
