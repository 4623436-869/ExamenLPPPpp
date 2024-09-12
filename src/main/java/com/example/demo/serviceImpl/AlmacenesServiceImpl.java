package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Almacenes;
import com.example.demo.repository.almacenesRepository;
import com.example.demo.service.AlmacenesService;

@Service
public class AlmacenesServiceImpl implements AlmacenesService {

    @Autowired
    private almacenesRepository almacenesRepository;

    @Override
    public Almacenes create(Almacenes almacen) {
        // Guardar un nuevo almacén en la base de datos
        return almacenesRepository.save(almacen);
    }

    @Override
    public Almacenes update(Almacenes almacen) {
        // Actualizar un almacén existente en la base de datos
        return almacenesRepository.save(almacen);
    }

    @Override
    public void delete(Long id) {
        // Eliminar un almacén por su ID
        almacenesRepository.deleteById(id);
    }

    @Override
    public Optional<Almacenes> read(Long id) {
        // Buscar un almacén por su ID
        return almacenesRepository.findById(id);
    }

    @Override
    public List<Almacenes> readAll() {
        // Obtener todos los almacenes
        return almacenesRepository.findAll();
    }
}
