package ru.egorkaaaa.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.FOUND,
        reason = "Requested user all ready exists"
)
public class animeAllReadyExistsException extends Exception {
    public animeAllReadyExistsException(String message) {
        super(message);
    }
}
