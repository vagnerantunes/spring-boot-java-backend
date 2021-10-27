package com.spring.java.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.java.backend.entities.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
