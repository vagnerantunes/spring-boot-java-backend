package com.spring.java.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.java.backend.entities.Fatura;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> {

}
