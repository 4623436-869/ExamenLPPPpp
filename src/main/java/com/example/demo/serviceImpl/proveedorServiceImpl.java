package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Proveedores;
import com.example.demo.repository.proveedorRepository;
import com.example.demo.service.proveedorService;

@Service
public class proveedorServiceImpl implements proveedorService {

    @Autowired
    private proveedorRepository proveedorRepository;

    @Override
    public Proveedores create(Proveedores proveedor) {
        // Guardar un nuevo objeto proveedores en la base de datos
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedores update(Proveedores proveedor) {
        // Actualizar un objeto proveedores existente en la base de datos
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void delete(Long id) {
        // Eliminar un objeto proveedores por su ID
        proveedorRepository.deleteById(id);
    }

    @Override
    public Optional<Proveedores> read(Long id) {
        // Buscar un objeto proveedores por su ID
        return proveedorRepository.findById(id);
    }

    @Override
    public List<Proveedores> readAll() {
        // Obtener todos los objetos proveedores en la base de datos
        return proveedorRepository.findAll();
    }
}
