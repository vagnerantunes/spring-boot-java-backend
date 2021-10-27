package com.spring.java.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.java.backend.entities.ParcelaBoleto;
import com.spring.java.backend.entities.pk.ParcelaBoletoPK;

@Repository
public interface ParcelaBoletoRepository extends JpaRepository<ParcelaBoleto, ParcelaBoletoPK>{

}
