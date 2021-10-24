package com.example.helloWorld.models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BaseResponse<K ,V> {
    private Map<K ,V> response;

    public BaseResponse(){
        this.response = new HashMap<>();
    }

    public void add(K key , V value){
        this.response.put(key,value);
    }
}
