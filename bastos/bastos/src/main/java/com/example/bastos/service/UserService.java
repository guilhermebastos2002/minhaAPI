package com.example.bastos.service;

import com.example.bastos.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@Service
public class UserService {

    private List<User> usuarios = new ArrayList<>();
    public boolean checkNameEquals(String nomeDigitado) {
                return usuarios.stream()
                                .anyMatch(user -> user.getName()
                                .equalsIgnoreCase(nomeDigitado));
    }
}
