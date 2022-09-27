package com.spring.java.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.java.backend.entities.Boleto;
import com.spring.java.backend.services.BoletoService;

@RestController
@RequestMapping(value = "/boletos")
public class BoletoResource {
	
	@Autowired
	private BoletoService service;
	
	@GetMapping
	public ResponseEntity<List<Boleto>> findAll(){
		List<Boleto> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Boleto> findById(@PathVariable Integer id){
		Boleto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Boleto> insert(@RequestBody Boleto obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Boleto> update(@PathVariable Integer id, @RequestBody Boleto obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
