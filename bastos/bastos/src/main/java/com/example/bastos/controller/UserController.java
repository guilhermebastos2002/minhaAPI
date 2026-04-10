package com.example.bastos.controller;

import com.example.bastos.domain.User;
import com.example.bastos.dtos.UserResponse;
import com.example.bastos.repository.UserRepository;
import com.example.bastos.service.UserService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

}
