package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TipoOrden;
import com.example.demo.repository.tipo_ordenRepository;
import com.example.demo.service.tipo_ordenService;

@Service
public class tipo_ordenServiceImpl implements tipo_ordenService {

    @Autowired
    private tipo_ordenRepository tipoOrdenRepository;

    @Override
    public TipoOrden create(TipoOrden tipoOrden) {
        // Guardar un nuevo objeto tipo_orden en la base de datos
        return tipoOrdenRepository.save(tipoOrden);
    }

    @Override
    public TipoOrden update(TipoOrden tipoOrden) {
        // Actualizar un objeto tipo_orden existente en la base de datos
        return tipoOrdenRepository.save(tipoOrden);
    }

    @Override
    public void delete(Long id) {
        // Eliminar un objeto tipo_orden por su ID
        tipoOrdenRepository.deleteById(id);
    }

    @Override
    public Optional<TipoOrden> read(Long id) {
        // Buscar un objeto tipo_orden por su ID
        return tipoOrdenRepository.findById(id);
    }

    @Override
    public List<TipoOrden> readAll() {
        // Obtener todos los objetos tipo_orden en la base de datos
        return tipoOrdenRepository.findAll();
    }
}
