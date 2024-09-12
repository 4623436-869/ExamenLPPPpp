package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.FormaPago;

@Repository
public interface forma_pagoRepository extends JpaRepository<FormaPago, Long> {
}
