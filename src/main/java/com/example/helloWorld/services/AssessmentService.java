package com.example.helloWorld.services;

import com.example.helloWorld.enums.RiskLevel;
import com.example.helloWorld.models.SelfAssesmentRequest;
import com.example.helloWorld.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService implements IAssesmentService{

    @Autowired
    private UserService userService;

    @Override
    public Double getRisk(SelfAssesmentRequest selfAssesmentRequest) throws Exception {
        Boolean isUserValid = userService.checkUserValid(selfAssesmentRequest.getUserId());
         if(!isUserValid){
             throw new Exception("User Not Found");
         }
         User user = userService.findUserById(selfAssesmentRequest.getUserId());
        RiskLevel risk = RiskLevel.LOW;
        if(selfAssesmentRequest.getSymptoms().size()>2 && (selfAssesmentRequest.getTravelHistory() || selfAssesmentRequest.getContactWithCovidPatient())){
            user.setIsCovidPositive(true);
            return RiskLevel.VERYHIGH.getRiskValue();
        }
        if(selfAssesmentRequest.getSymptoms().size()==2 && (selfAssesmentRequest.getTravelHistory() || selfAssesmentRequest.getContactWithCovidPatient())){
           user.setIsCovidPositive(true);
            return RiskLevel.HIGH.getRiskValue();
        }
        if(selfAssesmentRequest.getSymptoms().size()==1 && (selfAssesmentRequest.getTravelHistory() || selfAssesmentRequest.getContactWithCovidPatient())){
            user.setIsCovidPositive(true);
            return RiskLevel.MEDIUM.getRiskValue();
        }
        userService.save(user);
        return risk.getRiskValue();
    }


    }


