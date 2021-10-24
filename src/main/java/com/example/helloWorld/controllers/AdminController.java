package com.example.helloWorld.controllers;

import com.example.helloWorld.models.BaseResponse;
import com.example.helloWorld.models.CovidResultRequest;
import com.example.helloWorld.models.SelfAssesmentRequest;
import com.example.helloWorld.services.IAdminService;
import com.example.helloWorld.services.IAssesmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @PostMapping("/result")
    public Map<String,String> selfAssess(@RequestBody CovidResultRequest covidResultRequest){
        BaseResponse<String ,String> baseResponse = new BaseResponse<>();
        try {
            Boolean isUpdated = adminService.updateResult(covidResultRequest);
            baseResponse.add("Updated" ,isUpdated.toString());

        } catch (Exception e) {
            baseResponse.add("exception" ,e.getMessage());
        }
        return baseResponse.getResponse();

    }
}
