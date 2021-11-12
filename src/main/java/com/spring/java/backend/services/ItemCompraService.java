package com.spring.java.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.backend.entities.ItemCompra;
import com.spring.java.backend.repositories.ItemCompraRepository;

@Service
public class ItemCompraService {
	
	@Autowired
	private ItemCompraRepository repository;
	
	public List<ItemCompra> findAll(){
		return repository.findAll();
	}
	
}
