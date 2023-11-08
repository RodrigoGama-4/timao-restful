package com.example.corinthians.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corinthians.domain.user.User;
import com.example.corinthians.dtos.AuthenticationDTO;
import com.example.corinthians.dtos.RegisterDTO;
import com.example.corinthians.repository.UserRepository;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data ){
        var userNameSenha = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(userNameSenha);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.email()) != null) return ResponseEntity.badRequest().build();
        
        String senhaEncript = new BCryptPasswordEncoder().encode(data.senha());
        User user = new User(data.email(), senhaEncript, data.role());

        this.repository.save(user);

        return ResponseEntity.ok().build();
    }

}
