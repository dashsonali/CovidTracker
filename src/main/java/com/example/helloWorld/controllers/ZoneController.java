package com.example.helloWorld.controllers;

import com.example.helloWorld.models.BaseResponse;
import com.example.helloWorld.models.CovidResultRequest;
import com.example.helloWorld.models.ZoneRequest;
import com.example.helloWorld.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/zone")
public class ZoneController {

    @Autowired
    ZoneService zoneService;

    @PostMapping("/info")
    public Map<String,String> getInfo(@RequestBody ZoneRequest zoneRequest){
        BaseResponse<String ,String> baseResponse = new BaseResponse<>();
        try {
            HashMap<String,String> info = zoneService.getZoneInfo(zoneRequest.getPinCode());
            return info;

        } catch (Exception e) {
            baseResponse.add("exception" ,e.getMessage());
        }
        return baseResponse.getResponse();

    }
}
