package com.freelance.employeeapi.controller;

import com.freelance.employeeapi.dto.AuthRequest;
import com.freelance.employeeapi.entity.User;
import com.freelance.employeeapi.repository.UserRepository;
import com.freelance.employeeapi.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repo;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public User signup(
            @RequestBody User user){

        return repo.save(user);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody AuthRequest req){

        User user = repo.findByUsername(
                        req.getUsername())
                .orElseThrow();

        if(user.getPassword()
                .equals(req.getPassword())){

            return jwtUtil.generateToken(
                    user.getUsername());
        }

        throw new RuntimeException(
                "Invalid Credentials");
    }
}