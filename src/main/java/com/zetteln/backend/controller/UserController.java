package com.zetteln.backend.controller;

import com.zetteln.backend.dto.UserDTO;
import com.zetteln.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> GetAllUsers() {
        List<UserDTO> users = userService.GetAllUsers();

        if (users.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> GetById(@PathVariable Long id) {
        UserDTO user = userService.GeById(id);

        if (user == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> CreateUser(@RequestBody UserDTO user) {
        UserDTO newUser = userService.CreateUser(user);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "User created successfully");
        response.put("userId", newUser.getId());
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> UpdateUser(@PathVariable Long id, @RequestBody UserDTO user) {
        Map<String, Object> response = new HashMap<>();

        if(userService.GeById(id) != null){
            UserDTO newUser = userService.UpdateUser(id, user);
            response.put("message", "User updated successfully");
            response.put("user", newUser);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } else {
            response.put("message", "User not found");
            response.put("userId", id);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> DeleteUser(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        if(userService.GeById(id) != null){
            userService.DeleteUser(id);
            response.put("message", "User updated successfully");
            response.put("userId", id);
            return new ResponseEntity<>(response,HttpStatus.CREATED);
        } else {
            response.put("message", "User not found");
            response.put("userId", id);
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }
}
