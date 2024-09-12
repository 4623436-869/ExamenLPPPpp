package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Ordenes;

public interface ordenesService {
    
    Ordenes create(Ordenes ordenes); 
    Ordenes update(Ordenes ordenes); 
    void delete(Long id); 
    Optional<Ordenes> read(Long id);
    List<Ordenes> readAll(); 
    
}
