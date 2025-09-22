package com.zetteln.backend.controller;

import com.zetteln.backend.entity.User;
import com.zetteln.backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //SHOW USERS
    @GetMapping
    public List<User> GetAllUsers() { return userService.GetAllUsers(); }

    //ADD USER
    @PostMapping
    public String CreateUser() { return "User created.";}

    //SEARCH USER BY ID

    //UPDATE USER DATA
    @PutMapping("/id")
    public String UpdateUser() { return "User updated";}

    //DELETE USER
    @DeleteMapping("/id")
    public String DeleteUser() { return "User deleted";}
}
