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

import com.example.demo.entity.Ordenes;
import com.example.demo.service.ordenesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ordenes")
public class ordenesController {

    @Autowired
    private ordenesService ordenesService;

    @GetMapping
    public ResponseEntity<List<Ordenes>> readAll() {
        try {
            List<Ordenes> ordenesList = ordenesService.readAll();
            if (ordenesList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ordenesList, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Ordenes> create(@Valid @RequestBody Ordenes orden) {
        try {
            Ordenes createdOrden = ordenesService.create(orden);
            return new ResponseEntity<>(createdOrden, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ordenes> getOrden(@PathVariable("id") Long id) {
        Optional<Ordenes> orden = ordenesService.read(id);
        return orden.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ordenes> updateOrden(@PathVariable("id") Long id, @Valid @RequestBody Ordenes orden) {
        Optional<Ordenes> existingOrden = ordenesService.read(id);
        if (existingOrden.isPresent()) {
            orden.setId(id);
            return new ResponseEntity<>(ordenesService.update(orden), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteOrden(@PathVariable("id") Long id) {
        try {
            ordenesService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
