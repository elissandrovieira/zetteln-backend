package com.zetteln.backend.service;

import com.zetteln.backend.entity.User;
import com.zetteln.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> GetAllUsers() {
        return userRepository.findAll();
    }

        public User GeById(Long id) {
            Optional<User> user = userRepository.findById(id);
            return user.orElse(null);
        }

    public User CreateUser(User user) {
        return userRepository.save(user);
    }

    public void DeleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User UpdateUser(Long id, User user) {
        return userRepository.existsById(id) ? userRepository.save(user) : null;
    }
}
