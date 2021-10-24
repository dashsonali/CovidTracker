package com.example.helloWorld.services;

import com.example.helloWorld.models.User;

public interface IUserService {
    void save(User user);

    User findUserByNameAndPhoneNumber(String name, String phoneNumber) throws Exception;

    User findUserById(Long userId) throws Exception;

    Boolean checkUserValid(Long userId);
}
