package com.zetteln.backend.mapper;

import com.zetteln.backend.dto.UserDTO;
import com.zetteln.backend.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserDTO userDTO) {

        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPasswordHash(userDTO.getPasswordHash());
        user.setCreatedAt(userDTO.getCreatedAt());
        user.setVaults(userDTO.getVaults());

        return user;
    }

    public UserDTO map(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPasswordHash(user.getPasswordHash());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setVaults(user.getVaults());

        return userDTO;
    }
}
