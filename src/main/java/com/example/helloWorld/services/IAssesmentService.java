package com.example.helloWorld.services;

import com.example.helloWorld.models.SelfAssesmentRequest;

public interface IAssesmentService {
    Double getRisk(SelfAssesmentRequest selfAssesmentRequest) throws Exception;
}
