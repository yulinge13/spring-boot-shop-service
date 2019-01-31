package com.example.demo.controller;

import com.example.demo.entity.Goods;
import com.example.demo.entity.ResultMessage;
import com.example.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin //跨域
public class GoodsControll {

    @Autowired
    private GoodsService goodsService;
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(){
        String name = "yulinge12";
        return name;
    }
    //获取所有的商品
    @RequestMapping(value = "/findLists",method = RequestMethod.GET)
    public Object findAll(){
        ResultMessage resultMessage = new ResultMessage();
        try {
            Object res =  resultMessage.successData(goodsService.findAll(),"获取成功");
            return res;
        }catch (Exception e){
            Object res =  resultMessage.failData(null,"获取失败");
            return res;
        }
    }
    //获取前端路由菜单
    @RequestMapping(value = "/getMenuLists",method = RequestMethod.GET)
    public Object getMenuLists(){
        ResultMessage resultMessage = new ResultMessage();
        try {
            Object res =  resultMessage.successData(goodsService.findAllMenuLists(),"获取成功");
            return res;
        }catch (Exception e){
            Object res =  resultMessage.failData(null,"获取失败");
            return res;
        }
    }
    //查询所有的一级分类
    @RequestMapping(value = "/getFirstClass",method = RequestMethod.GET)
    public Object getFirstClass(){
        ResultMessage resultMessage = new ResultMessage();
        try {
            Object res =  resultMessage.successData(goodsService.getFirstClass(),"获取成功");
            return res;
        }catch (Exception e){
            Object res =  resultMessage.failData(null,"获取失败");
            return res;
        }
    }

    //获取分类
    @RequestMapping(value = "/getClass",method = RequestMethod.GET)
    public Object getClassLists(Integer classFirstId){
        System.out.println(classFirstId);
        ResultMessage resultMessage = new ResultMessage();
        try {
            Object res =  resultMessage.successData(goodsService.getClassLists(classFirstId),"获取成功");
            return res;
        }catch (Exception e){
            e.printStackTrace();
            Object res =  resultMessage.failData(null,"获取失败");
            return res;
        }
    }
}

