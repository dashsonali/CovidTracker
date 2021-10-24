package com.example.helloWorld.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SelfAssesmentRequest {
    private Long userId;
    private List<String> symptoms;
    private Boolean travelHistory;
    private Boolean contactWithCovidPatient;

}
