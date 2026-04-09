package com.example.bastos.controller;

import com.example.bastos.domain.User;
import com.example.bastos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    User user = new User("Vitória", "vic@gmail.com");
    User user1 = new User("Guilherme", "gui.weil@hotmail.com");

    @GetMapping("/user")
    public String getName() {
        return user.getName();
    }

    @GetMapping("/user")
    public String getEmail() {
        return user.getEmail();
    }

    @PostMapping
    public String setName(String name) {
            if (userService.checkNameEquals(name)) {
                return "Esse usuário já existe";
            }else {
                user.setName(name);
                return "Usuário cadastrado com sucesso!";
            }

    }

    @PostMapping
    public void setEmail(String email) {
        user.setEmail(email);
    }
}
