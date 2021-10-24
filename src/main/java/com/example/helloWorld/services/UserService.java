package com.example.helloWorld.services;

import com.example.helloWorld.models.User;
import com.example.helloWorld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUserByNameAndPhoneNumber(String name, String phoneNumber) throws Exception {
        User savedUser = userRepository.findUserByNameAndPhoneNumber(name, phoneNumber);
        if (savedUser == null) {
            throw new Exception("User Not Found");
        }
        return savedUser;
    }

    @Override
    public User findUserById(Long userId) throws Exception {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new Exception("User Not Found");
        }
        return user;
    }

    @Override
    public Boolean checkUserValid(Long userId) {
        try {
            this.findUserById(userId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
