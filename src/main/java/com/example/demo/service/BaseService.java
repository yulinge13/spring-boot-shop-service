package com.example.demo.service;

import java.util.List;

public interface BaseService<T> {
    //所有商品
    List<T> findAll();
}
