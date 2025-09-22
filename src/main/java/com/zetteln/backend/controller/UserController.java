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

    @GetMapping
    public List<User> GetAllUsers() {
        return userService.GetAllUsers();
    }

    @GetMapping("/{id}")
    public User GetById(@PathVariable Long id) {
        return userService.GeById(id);
    }

    @PostMapping
    public User CreateUser(@RequestBody User user) {
        return userService.CreateUser(user);
    }

    @PutMapping("/{id}")
    public User UpdateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.UpdateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String DeleteUser(@PathVariable Long id) {
        userService.DeleteUser(id);
        return "User deleted.";
    }
}
