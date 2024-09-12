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

import com.example.demo.entity.TipoOrden;
import com.example.demo.service.tipo_ordenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipo-orden")
public class tipo_ordenController {

    @Autowired
    private tipo_ordenService tipoOrdenService;

    @GetMapping
    public ResponseEntity<List<TipoOrden>> readAll() {
        try {
            List<TipoOrden> tipoOrdenList = tipoOrdenService.readAll();
            if (tipoOrdenList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tipoOrdenList, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<TipoOrden> create(@Valid @RequestBody TipoOrden tipoOrden) {
        try {
            TipoOrden createdTipoOrden = tipoOrdenService.create(tipoOrden);
            return new ResponseEntity<>(createdTipoOrden, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoOrden> getTipoOrden(@PathVariable("id") Long id) {
        Optional<TipoOrden> tipoOrden = tipoOrdenService.read(id);
        return tipoOrden.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoOrden> updateTipoOrden(@PathVariable("id") Long id, @Valid @RequestBody TipoOrden tipoOrden) {
        Optional<TipoOrden> existingTipoOrden = tipoOrdenService.read(id);
        if (existingTipoOrden.isPresent()) {
            tipoOrden.setId(id);
            return new ResponseEntity<>(tipoOrdenService.update(tipoOrden), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTipoOrden(@PathVariable("id") Long id) {
        try {
            tipoOrdenService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
