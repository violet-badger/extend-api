package com.extend.virtualcardapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignInController {
    @GetMapping("/signin")
    public ResponseEntity<String> signIn() {
        try {
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to sign in: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Sign in successful", HttpStatus.OK);
    }
}
