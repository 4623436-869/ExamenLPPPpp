package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.Proveedores;

public interface proveedorService {
    
    Proveedores create(Proveedores proveedor); 
    Proveedores update(Proveedores proveedor); 
    void delete(Long id); 
    Optional<Proveedores> read(Long id);
    List<Proveedores> readAll(); 
    
}
