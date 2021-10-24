package com.example.helloWorld.services;

import com.example.helloWorld.enums.RoleType;
import com.example.helloWorld.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements IRegistrationService{

   @Autowired
   private IUserService userService;

   @Override
    public Long registerUser(User user) throws Exception {
        user.setRole(RoleType.END_USER);
        userService.save(user);
        User savedUser = userService.findUserByNameAndPhoneNumber(user.getName(),user.getPhoneNumber());
        return savedUser.getUserId();
    }

    @Override
    public Long registerAdmin(User user) throws Exception {
        user.setRole(RoleType.ADMIN);
        userService.save(user);
        User savedUser = userService.findUserByNameAndPhoneNumber(user.getName(),user.getPhoneNumber());
        return savedUser.getUserId();
    }
}
