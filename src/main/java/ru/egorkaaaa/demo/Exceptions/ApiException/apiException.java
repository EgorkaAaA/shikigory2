package ru.egorkaaaa.demo.Exceptions.ApiException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
public class apiException {
    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime time;
}
