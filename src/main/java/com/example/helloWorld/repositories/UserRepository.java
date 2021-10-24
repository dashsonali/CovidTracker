package com.example.helloWorld.repositories;

import com.example.helloWorld.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByNameAndPhoneNumber(String name, String phoneNumber);

    @Query(value = "select count(u) from User u where u.isCovidPositive = true  and u.pinCode = :pinCode")
    int getNumOfCases(Long pinCode);
}
