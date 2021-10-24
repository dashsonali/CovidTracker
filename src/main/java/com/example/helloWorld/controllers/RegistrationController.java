package com.example.helloWorld.controllers;

import com.example.helloWorld.models.BaseResponse;
import com.example.helloWorld.models.User;
import com.example.helloWorld.services.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/register")
public class RegistrationController {

    @Autowired
    private IRegistrationService registrationService;

    @PostMapping("/user")
    public Map<String,String> registerUser(@RequestBody User user){
        BaseResponse<String ,String> baseResponse = new BaseResponse<>();
        try {
            Long userId = registrationService.registerUser(user);
            baseResponse.add("userId" ,userId.toString());

        } catch (Exception e) {
            baseResponse.add("exception" ,e.getMessage());
        }
        return baseResponse.getResponse();
    }

    @PostMapping("/admin")
    public Map<String,String> registerAdmin(@RequestBody User user){
        BaseResponse<String ,String> baseResponse = new BaseResponse<>();
        try {
            Long userId = registrationService.registerAdmin(user);
            baseResponse.add("adminId" ,userId.toString());

        } catch (Exception e) {
            baseResponse.add("exception" ,e.getMessage());
        }
        return baseResponse.getResponse();
    }
}
