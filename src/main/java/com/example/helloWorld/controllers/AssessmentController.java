package com.example.helloWorld.controllers;

import com.example.helloWorld.models.BaseResponse;
import com.example.helloWorld.models.SelfAssesmentRequest;
import com.example.helloWorld.services.IAssesmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class AssessmentController {

    @Autowired
    private IAssesmentService assesmentService;

    @PostMapping("/assess")
    public Map<String,String> selfAssess(@RequestBody SelfAssesmentRequest selfAssesmentRequest){
        BaseResponse<String ,String> baseResponse = new BaseResponse<>();
        try {
            Double risk = assesmentService.getRisk(selfAssesmentRequest);
            baseResponse.add("riskPercentage" ,risk.toString()+"%");

        } catch (Exception e) {
            baseResponse.add("exception" ,e.getMessage());
        }
        return baseResponse.getResponse();

    }
}
