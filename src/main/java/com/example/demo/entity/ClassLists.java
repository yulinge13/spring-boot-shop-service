package com.example.demo.entity;
//获取分类
public class ClassLists {
    private Integer id; //id
    private String firstClassName;//一级分类的名字
    private String secClassName; //二级分类的名字
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstClassName() {
        return firstClassName;
    }

    public void setFirstClassName(String firstClassName) {
        this.firstClassName = firstClassName;
    }

    public String getSecClassName() {
        return secClassName;
    }

    public void setSecClassName(String secClassName) {
        this.secClassName = secClassName;
    }

}
