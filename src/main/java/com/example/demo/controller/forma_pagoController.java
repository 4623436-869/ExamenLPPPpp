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

import com.example.demo.entity.FormaPago;
import com.example.demo.service.forma_pagoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/forma_pago")
public class forma_pagoController {

    @Autowired
    private forma_pagoService formaPagoService;

    @GetMapping
    public ResponseEntity<List<FormaPago>> readAll() {
        try {
            List<FormaPago> formaPagos = formaPagoService.readAll();
            if (formaPagos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(formaPagos, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<FormaPago> create(@Valid @RequestBody FormaPago formaPago) {
        try {
            FormaPago createdFormaPago = formaPagoService.create(formaPago);
            return new ResponseEntity<>(createdFormaPago, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPago> getFormaPago(@PathVariable("id") Long id) {
        Optional<FormaPago> formaPago = formaPagoService.read(id);
        return formaPago.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormaPago> updateFormaPago(@PathVariable("id") Long id, @Valid @RequestBody FormaPago formaPago) {
        Optional<FormaPago> existingFormaPago = formaPagoService.read(id);
        if (existingFormaPago.isPresent()) {
            formaPago.setId(id);
            return new ResponseEntity<>(formaPagoService.update(formaPago), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFormaPago(@PathVariable("id") Long id) {
        try {
            formaPagoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
