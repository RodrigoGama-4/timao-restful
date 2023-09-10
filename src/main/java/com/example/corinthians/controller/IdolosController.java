package com.example.corinthians.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.corinthians.dtos.IdoloRequestDTO;
import com.example.corinthians.dtos.IdolosDTO;
import com.example.corinthians.idolo.Idolo;
import com.example.corinthians.repository.IdolosRepository;

@RestController
@RequestMapping("idolos")
public class IdolosController {
    @Autowired
    private IdolosRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveIdolo(@RequestBody IdoloRequestDTO data){
        Idolo newIdolo = new Idolo(data);
        repository.save(newIdolo);
        return;
    }
    
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<IdoloRequestDTO> getAll(){
        List<IdoloRequestDTO> idolosLista = repository.findAll()
    .stream()
    .map(idolo -> new IdoloRequestDTO(idolo.getNome(), idolo.getImage(), idolo.getQuantidadeTitulos()))
    .toList();
        return idolosLista;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteIdolo(@PathVariable Long id) {
        Idolo idolo = repository.findById(id).get();
        repository.delete(idolo);
    }

    @PutMapping("/{id}")
    public IdolosDTO updateIdolo(@PathVariable Long id, @RequestBody IdoloRequestDTO data) {
        Idolo idolo = repository.findById(id).get();
        idolo.setNome(data.nome());
        idolo.setImage(data.image());
        idolo.setQuantidadeTitulos(data.quantidadeTitulos());

        repository.save(idolo);

        return new IdolosDTO(idolo);
    }

}
