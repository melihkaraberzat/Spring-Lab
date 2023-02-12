package com.LaboratuvarApp.service;

import com.LaboratuvarApp.UserRepository;
import com.LaboratuvarApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    public  UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User findUserByUsernameAndPassword(String username,Long password){
        return userRepository.findUserByUsernameAndPassword(username,password);
    }
}
