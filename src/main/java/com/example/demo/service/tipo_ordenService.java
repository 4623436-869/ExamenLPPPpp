package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entity.TipoOrden;

public interface tipo_ordenService {
    
	TipoOrden create(TipoOrden tipoOrden); 
	TipoOrden update(TipoOrden tipoOrden); 
    void delete(Long id); 
    Optional<TipoOrden> read(Long id);
    List<TipoOrden> readAll(); 
    
}
