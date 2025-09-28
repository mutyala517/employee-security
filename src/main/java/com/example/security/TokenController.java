package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public TokenController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> generateToken(@RequestParam String subject) {
        String token = jwtTokenProvider.createToken(subject);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}

