package com.example.demo.entity;

//查询所有的一级分类
public class FirstClass {
    private Integer id; //ID
    private String name;//名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
