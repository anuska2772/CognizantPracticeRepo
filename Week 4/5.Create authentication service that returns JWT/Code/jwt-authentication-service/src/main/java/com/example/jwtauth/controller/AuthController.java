package com.example.jwtauth.controller;

import com.example.jwtauth.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Basic ")) {
            // Decode credentials
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);

            String[] parts = credentials.split(":", 2);
            if (parts.length != 2) {
                return ResponseEntity.status(400).body("{\"error\":\"Invalid format\"}");
            }

            String username = parts[0];
            String password = parts[1];

            // Validate credentials (hardcoded)
            if ("user".equals(username) && "pwd".equals(password)) {
                String token = jwtUtil.generateToken(username);
                return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
            } else {
                return ResponseEntity.status(401).body("{\"error\":\"Invalid credentials\"}");
            }
        }

        return ResponseEntity.status(400).body("{\"error\":\"Missing Authorization header\"}");
    }
}
