package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Proveedores;
import com.example.demo.service.proveedorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/proveedores")
public class proveedorController {

    @Autowired
    private proveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedores>> readAll() {
        try {
            List<Proveedores> proveedoresList = proveedorService.readAll();
            if (proveedoresList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(proveedoresList, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Proveedores> create(@Valid @RequestBody Proveedores proveedor) {
        try {
            Proveedores createdProveedor = proveedorService.create(proveedor);
            return new ResponseEntity<>(createdProveedor, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedores> getProveedor(@PathVariable("id") Long id) {
        Optional<Proveedores> proveedor = proveedorService.read(id);
        return proveedor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedores> updateProveedor(@PathVariable("id") Long id, @Valid @RequestBody Proveedores proveedor) {
        Optional<Proveedores> existingProveedor = proveedorService.read(id);
        if (existingProveedor.isPresent()) {
            proveedor.setId(id);
            return new ResponseEntity<>(proveedorService.update(proveedor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProveedor(@PathVariable("id") Long id) {
        try {
            proveedorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
