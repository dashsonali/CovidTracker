package com.example.helloWorld.services;

import com.example.helloWorld.enums.CovidResult;
import com.example.helloWorld.enums.RoleType;
import com.example.helloWorld.models.CovidResultRequest;
import com.example.helloWorld.models.User;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class AdminService  extends UserService implements IAdminService{

    @Override
    public Boolean updateResult(CovidResultRequest covidResultRequest) throws Exception {
        if(!isAdmin(covidResultRequest.getAdminId())){
            throw new Exception("User Not Authorized to Update Result");
        }
        User user = this.findUserById(covidResultRequest.getUserId());
        boolean result = CovidResult.valueOf(covidResultRequest.getResult().toUpperCase(Locale.ROOT)) == CovidResult.POSITIVE;
        user.setIsCovidPositive(result);
        this.save(user);
        return true;
    }

    public Boolean isAdmin(Long adminId) throws Exception {
        User admin = this.findUserById(adminId);
        return admin.getRole() == RoleType.ADMIN;
    }
}
