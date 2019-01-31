package com.example.demo.service;

import com.example.demo.entity.ClassLists;
import com.example.demo.entity.FirstClass;
import com.example.demo.entity.Goods;
import com.example.demo.entity.MenuLists;

import java.util.List;

public interface GoodsService extends BaseService<Goods>{

    //路由菜单
    List<MenuLists> findAllMenuLists();
    //查询所有的一级分类
    List<FirstClass> getFirstClass();
    //获取分类
    List<ClassLists> getClassLists(Integer firstClassId);
}
