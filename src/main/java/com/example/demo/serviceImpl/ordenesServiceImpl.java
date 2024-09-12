package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ordenes;
import com.example.demo.repository.ordenesRepository;
import com.example.demo.service.ordenesService;

@Service
public class ordenesServiceImpl implements ordenesService {

    @Autowired
    private ordenesRepository ordenesRepository;

    @Override
    public Ordenes create(Ordenes orden) {
        // Guardar un nuevo objeto ordenes en la base de datos
        return ordenesRepository.save(orden);
    }

    @Override
    public Ordenes update(Ordenes orden) {
        // Actualizar un objeto ordenes existente en la base de datos
        return ordenesRepository.save(orden);
    }

    @Override
    public void delete(Long id) {
        // Eliminar un objeto ordenes por su ID
        ordenesRepository.deleteById(id);
    }

    @Override
    public Optional<Ordenes> read(Long id) {
        // Buscar un objeto ordenes por su ID
        return ordenesRepository.findById(id);
    }

    @Override
    public List<Ordenes> readAll() {
        // Obtener todos los objetos ordenes en la base de datos
        return ordenesRepository.findAll();
    }
}
