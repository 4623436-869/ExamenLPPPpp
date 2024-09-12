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

import com.example.demo.entity.Almacenes;
import com.example.demo.service.AlmacenesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/almacenes")
public class AlmacenesController {

    @Autowired
    private AlmacenesService almacenesService;

    @GetMapping
    public ResponseEntity<List<Almacenes>> readAll() {
        try {
            List<Almacenes> almacenes = almacenesService.readAll();
            if (almacenes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(almacenes, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Almacenes> create(@Valid @RequestBody Almacenes almacen) {
        try {
            Almacenes createdAlmacen = almacenesService.create(almacen);
            return new ResponseEntity<>(createdAlmacen, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Almacenes> getAlmacen(@PathVariable("id") Long id) {
        Optional<Almacenes> almacen = almacenesService.read(id);
        return almacen.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Almacenes> updateAlmacen(@PathVariable("id") Long id, @Valid @RequestBody Almacenes almacen) {
        Optional<Almacenes> existingAlmacen = almacenesService.read(id);
        if (existingAlmacen.isPresent()) {
            almacen.setId(id);
            return new ResponseEntity<>(almacenesService.update(almacen), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAlmacen(@PathVariable("id") Long id) {
        try {
            almacenesService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
