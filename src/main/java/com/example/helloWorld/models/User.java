package com.example.helloWorld.models;

import com.example.helloWorld.enums.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;
    private String name;
    private String phoneNumber;
    private String pinCode;
    @Enumerated(EnumType.STRING)
    private RoleType role;
    private Boolean isCovidPositive;

}
