package ru.egorkaaaa.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.FOUND,
        reason = "Requested user all ready exists"
)
public class userAllReadyExistsException extends Exception{
    public userAllReadyExistsException(String message) {
        super(message);
    }
}
