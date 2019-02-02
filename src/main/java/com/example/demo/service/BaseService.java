package com.example.demo.service;

import java.util.List;

public interface BaseService<T> {
    //所有商品
    List<T> findAll();

    //查询打个商品
    T findOne(String id);

    //更新单个商品
    Integer upDateOne(T t);
}
