package com.example.helloWorld.services;

import com.example.helloWorld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ZoneService {

    @Autowired
    UserRepository userRepository;

    public HashMap<String ,String> getZoneInfo(Long pinCode){
        int numOfCases = userRepository.getNumOfCases(pinCode);
        String color = "GREEN";
        if(numOfCases > 5){
            color = "RED";
        }
        if(numOfCases <=5 && numOfCases>0){
            color = "ORANGE";
        }
        HashMap<String ,String> result = new HashMap<>();
        result.put("numOfCases" ,String.valueOf( numOfCases));
        result.put("zoneType" , color);
        return result;
    }


}
