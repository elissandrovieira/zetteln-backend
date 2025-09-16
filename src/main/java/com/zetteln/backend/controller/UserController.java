package com.zetteln.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/greetings")
    public String Greetings() {
        return "This is my first message in this route!";
    }
}
