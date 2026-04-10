package com.example.bastos.service;

import com.example.bastos.domain.User;
import com.example.bastos.dtos.UserResponse;
import com.example.bastos.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@Service
public class UserService {

    private final UserRepository userRepository;
    private List<User> usuarios = new ArrayList<>();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkNameEquals(String nomeDigitado) {
        return userRepository.findAll()
                .stream()
                .anyMatch(user -> user.getName()
                        .equalsIgnoreCase(nomeDigitado));
    }

    public List<UserResponse> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(user.getName(), user.getEmail()))
                .toList();
    }

    public String registerUser(@RequestBody User user) {
        if (checkNameEquals(user.getName())) {
            return "Esse usuário já existe.";
        } else {
            userRepository.save(user);
            return "Usuário cadastrado com sucesso!";
        }

    }

    public UserResponse findById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return new UserResponse(user.getName(), user.getEmail());
    }
}