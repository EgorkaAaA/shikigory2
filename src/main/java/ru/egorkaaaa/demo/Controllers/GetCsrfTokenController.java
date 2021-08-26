package ru.egorkaaaa.demo.Controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get/csrf-token")
public class GetCsrfTokenController {
    @GetMapping
    public ResponseEntity<HttpStatus> getCsrfTokenRequest() {
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
