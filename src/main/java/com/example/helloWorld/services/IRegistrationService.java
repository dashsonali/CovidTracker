package com.example.helloWorld.services;

import com.example.helloWorld.models.User;

public interface IRegistrationService {
    Long registerUser(User user) throws Exception;

    Long registerAdmin(User user) throws Exception;
}
