package com.example.corinthians.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corinthians.domain.idolo.Idolo;

public interface IdolosRepository extends JpaRepository<Idolo, Long>{
    
}
