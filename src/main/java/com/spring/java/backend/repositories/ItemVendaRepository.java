package com.spring.java.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.java.backend.entities.ItemVenda;
import com.spring.java.backend.entities.pk.ItemVendaPK;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, ItemVendaPK>{

}