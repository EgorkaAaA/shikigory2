package ru.egorkaaaa.demo.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.egorkaaaa.demo.Entities.user;
import ru.egorkaaaa.demo.Exceptions.userAllReadyExistsException;
import ru.egorkaaaa.demo.Services.userService;
import ru.egorkaaaa.demo.Shikigori2Application;

@RestController
@RequestMapping("/post/reg")
public class registrationController {
    private final userService userService;

    private final Logger logger = LoggerFactory.getLogger(Shikigori2Application.class);

    @Autowired
    public registrationController(ru.egorkaaaa.demo.Services.userService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<user> userRegistrationPage(@ModelAttribute user user) {
        try {
            userService.createUser(user);
            logger.info("User created");

            return new ResponseEntity<>(user, HttpStatus.CREATED);

        } catch (Exception e) {
            logger.error(e.getMessage(),user);
        }
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }
}
