package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.backend.entities.Fornecedor;
import com.spring.java.backend.repositories.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository repository;
	
	public List<Fornecedor> findAll(){
		return repository.findAll();
		
	}
	
	public Fornecedor findById(Integer id) {
		Optional<Fornecedor> obj = repository.findById(id);
		return obj.get();
		
	}
	
	public Fornecedor insert(Fornecedor obj) {
		return repository.save(obj);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Fornecedor update(Integer id, Fornecedor obj) {
		Fornecedor entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Fornecedor entity, Fornecedor obj) {
		entity.setForContato(obj.getForContato());
		entity.setForEmail(obj.getForEmail());
		entity.setForEndereco(obj.getForEndereco());
		entity.setForFantasia(obj.getForFantasia());
		entity.setForFlag(obj.getForFlag());
		entity.setForNome(obj.getForNome());
		entity.setForTipo(obj.getForTipo());
	}	
	
}