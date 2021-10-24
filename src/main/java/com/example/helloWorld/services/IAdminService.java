package com.example.helloWorld.services;

import com.example.helloWorld.models.CovidResultRequest;

public interface IAdminService {
    public Boolean updateResult(CovidResultRequest covidResultRequest) throws Exception;
    public Boolean isAdmin(Long adminId) throws Exception;

}
