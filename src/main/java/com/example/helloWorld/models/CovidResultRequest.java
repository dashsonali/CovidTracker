package com.example.helloWorld.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidResultRequest {
    private Long userId;
    private Long  adminId;
    private String result;
}
