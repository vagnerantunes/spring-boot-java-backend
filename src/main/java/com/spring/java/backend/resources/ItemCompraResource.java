package com.spring.java.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.java.backend.entities.ItemCompra;
import com.spring.java.backend.services.ItemCompraService;

@RestController
@RequestMapping(value = "/{itenscompra}")
public class ItemCompraResource {
	
	@Autowired
	private ItemCompraService service;
	
	@GetMapping
	public ResponseEntity<List<ItemCompra>> findAll(){
		List<ItemCompra> list = service.findAll();
		return ResponseEntity.ok().body(list);		
		
	}
}
