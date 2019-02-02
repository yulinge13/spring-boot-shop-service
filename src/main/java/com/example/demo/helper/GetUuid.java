package com.example.demo.helper;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetUuid {
    public <T> String getUUID(T t){
        String  uuid =  UUID.randomUUID().toString().replace("-","");
        return  uuid;
    }
}
