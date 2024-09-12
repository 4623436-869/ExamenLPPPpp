package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FormaPago;
import com.example.demo.repository.forma_pagoRepository;
import com.example.demo.service.forma_pagoService;

@Service
public class forma_pagoServiceImpl implements forma_pagoService {

    @Autowired
    private forma_pagoRepository formaPagoRepository;

    @Override
    public FormaPago create(FormaPago formaPago) {
        // Guardar un nuevo forma_pago en la base de datos
        return formaPagoRepository.save(formaPago);
    }

    @Override
    public FormaPago update(FormaPago formaPago) {
        // Actualizar un forma_pago existente en la base de datos
        return formaPagoRepository.save(formaPago);
    }

    @Override
    public void delete(Long id) {
        // Eliminar un forma_pago por su ID
        formaPagoRepository.deleteById(id);
    }

    @Override
    public Optional<FormaPago> read(Long id) {
        // Buscar un forma_pago por su ID
        return formaPagoRepository.findById(id);
    }

    @Override
    public List<FormaPago> readAll() {
        // Obtener todos los registros de forma_pago
        return formaPagoRepository.findAll();
    }
}
