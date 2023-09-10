package com.example.corinthians.idolo;

import com.example.corinthians.dtos.IdoloRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "idolos")
@Entity(name = "idolos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Idolo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String image;
    private Integer quantidadeTitulos;

    public Idolo(IdoloRequestDTO data){
        this.nome = data.nome();
        this.image = data.image();
        this.quantidadeTitulos = data.quantidadeTitulos();
    }
}
