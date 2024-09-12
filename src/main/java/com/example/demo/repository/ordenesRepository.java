package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Ordenes;

@Repository
public interface ordenesRepository extends JpaRepository<Ordenes, Long> {
}
