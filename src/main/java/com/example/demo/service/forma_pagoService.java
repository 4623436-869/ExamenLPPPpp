package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.FormaPago;

public interface forma_pagoService {
    
	FormaPago create(FormaPago formaPago); 
	FormaPago update(FormaPago formaPago); 
    void delete(Long id); 
    Optional<FormaPago> read(Long id);
    List<FormaPago> readAll(); 
    
}
