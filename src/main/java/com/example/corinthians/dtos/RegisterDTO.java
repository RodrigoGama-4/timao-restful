package com.example.corinthians.dtos;

import com.example.corinthians.domain.user.UserRole;

public record RegisterDTO(String email, String senha, UserRole role) {

}
