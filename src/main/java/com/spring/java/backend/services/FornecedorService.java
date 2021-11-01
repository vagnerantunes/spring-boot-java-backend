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
	
	public Fornecedor findById(Long id) {
		Optional<Fornecedor> obj = repository.findById(id);
		return obj.get();
		
	}
	
	public Fornecedor insert(Fornecedor obj) {
		return repository.save(obj);
		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	@SuppressWarnings("deprecation")
	public Fornecedor update(Long id, Fornecedor obj) {
		Fornecedor entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
	}

	private void updateData(Fornecedor entity, Fornecedor obj) {
		entity.setFOR_CONTATO(obj.getFOR_CONTATO());
		entity.setFOR_EMAIL(obj.getFOR_EMAIL());
		entity.setFOR_ENDERECO(obj.getFOR_ENDERECO());
		entity.setFOR_FANTASIA(obj.getFOR_FANTASIA());
		entity.setFOR_FLAG(obj.getFOR_FLAG());
		entity.setFOR_NOME(obj.getFOR_NOME());
		entity.setFOR_TIPO(obj.getFOR_TIPO());
	}	
	
}