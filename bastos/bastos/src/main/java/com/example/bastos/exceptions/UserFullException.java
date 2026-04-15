package com.example.bastos.exceptions;

public class UserFullException extends RuntimeException {
    public UserFullException() { super("Lista de usuários cheia!");}

    public UserFullException(String message) {
        super(message);
    }
}
