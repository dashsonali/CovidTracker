package com.example.helloWorld.enums;

public enum RiskLevel {
    VERYHIGH(95.0),
    HIGH(75.0),
    MEDIUM(50.0),
    LOW(5.0);
    Double riskValue;

    RiskLevel(double riskValue) {
        this.riskValue = riskValue;
    }
    public Double getRiskValue(){
        return this.riskValue;
    }
}
