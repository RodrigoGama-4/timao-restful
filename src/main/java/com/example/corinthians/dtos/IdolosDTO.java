package com.example.corinthians.dtos;

import com.example.corinthians.idolo.Idolo;

public record IdolosDTO(Long id, String name, String image, Integer quantiadeTitulos) {
    public IdolosDTO(Idolo idolo){
        this(idolo.getId(), idolo.getNome(), idolo.getImage(), idolo.getQuantidadeTitulos());
    }
}
