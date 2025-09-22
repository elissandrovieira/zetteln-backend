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
    public List<User> GetAllUsers() {
        return userService.GetAllUsers();
    }

    //SEARCH USER BY ID
    @GetMapping("/{id}")
    public User GetById(@PathVariable Long id) {
        return userService.GeById(id);
    }

    //ADD USER
    @PostMapping
    public User CreateUser(@RequestBody User user) {
        return userService.CreateUser(user);
    }

    //UPDATE USER DATA
    @PutMapping("/id")
    public String UpdateUser() { return "User updated";}

    //DELETE USER
    @DeleteMapping("/id")
    public String DeleteUser() { return "User deleted";}
}
