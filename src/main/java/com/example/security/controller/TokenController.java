package com.example.security.controller;

import com.example.security.config.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

    private final JwtTokenProvider jwtTokenProvider;

    public TokenController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestParam String subject) {
        String token = jwtTokenProvider.createToken(subject);
        return ResponseEntity.ok(token);
    }
}
