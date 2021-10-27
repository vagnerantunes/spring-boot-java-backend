package com.spring.java.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.java.backend.entities.ItemCompra;
import com.spring.java.backend.entities.pk.ItemCompraPK;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, ItemCompraPK>{

}
