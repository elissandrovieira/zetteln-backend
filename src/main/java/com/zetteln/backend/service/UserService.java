package com.zetteln.backend.service;

import com.zetteln.backend.dto.UserDTO;
import com.zetteln.backend.entity.User;
import com.zetteln.backend.mapper.UserMapper;
import com.zetteln.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    final private UserRepository userRepository;
    final private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> GetAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }

    public UserDTO GeById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::map)
                .orElse(null);
    }

    public UserDTO CreateUser(UserDTO userDTO) {
        User user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
    }

    public void DeleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDTO UpdateUser(Long id, UserDTO userDTO) {
        Optional<User> userExist = userRepository.findById(id);
        if (userExist.isPresent()) {
            User user = userMapper.map(userDTO);
            user.setId(id);
            userRepository.save(user);
            return userMapper.map(user);
        }
        return null;
    }
}
