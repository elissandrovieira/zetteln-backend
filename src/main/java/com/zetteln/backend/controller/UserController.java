package com.zetteln.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/greetings")
    public String Greetings() {return "This is my first message in this route!";}

    //ADD USER
    @PostMapping("/users")
    public String CreateUser() { return "User created.";}

    //SHOW USERS
    @GetMapping("/users")
    public String GetAllUsers() { return "All users.";}

    //SEARCH USER BY ID

    //UPDATE USER DATA
    @PutMapping("/userid")
    public String UpdateUser() { return "User updated";}

    //DELETE USER
    @DeleteMapping("/userid")
    public String DeleteUser() { return "User deleted";}
}
