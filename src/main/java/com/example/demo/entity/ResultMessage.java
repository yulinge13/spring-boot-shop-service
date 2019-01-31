package com.example.demo.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResultMessage implements Serializable {
    private boolean success;
    private String msg;
    public Object successData(Object data,String msg){
        Map<String,Object> map =new HashMap<>();
        map.put("success",true);
        map.put("data",data);
        map.put("code",200);
        map.put("msg",msg);
        return map;
    }
    public Object failData(Object data,String msg){
        Map<String,Object> map =new HashMap<>();
        map.put("success",false);
        map.put("data",data);
        map.put("code",400);
        map.put("msg",msg);
        return map;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
