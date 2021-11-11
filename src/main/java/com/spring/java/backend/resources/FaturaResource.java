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

import com.spring.java.backend.entities.Fatura;
import com.spring.java.backend.services.FaturaService;

@RestController
@RequestMapping(value = "/faturas")
public class FaturaResource {
	
	@Autowired
	private FaturaService service;
	
	@GetMapping
	public ResponseEntity<List<Fatura>> findAll(){
		List<Fatura> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Fatura> findById(@PathVariable Long id){
		Fatura obj = service.findById(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PostMapping
	public ResponseEntity<Fatura> insert(@RequestBody Fatura obj){
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Fatura> update(@PathVariable Long id, @RequestBody Fatura obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);	
		
	}
	
}
