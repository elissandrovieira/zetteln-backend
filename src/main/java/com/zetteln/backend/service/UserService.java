package com.zetteln.backend.service;

import com.zetteln.backend.entity.User;
import com.zetteln.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> GetAllUsers () { return userRepository.findAll();}
}
