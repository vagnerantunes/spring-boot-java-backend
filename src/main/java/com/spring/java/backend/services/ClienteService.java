package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.java.backend.entities.Cliente;
import com.spring.java.backend.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();

	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Cliente update(Integer id, Cliente obj) {
		Cliente entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setCliNome(obj.getCliNome());
		entity.setCliTipo(obj.getCliTipo());
		entity.setCliCpfCnpj(obj.getCliCpfCnpj());
		entity.setCliDataNascimento(obj.getCliDataNascimento());
		entity.setCliContato(obj.getCliContato());
		entity.setCliEmail(obj.getCliEmail());
		entity.setCliRazaoSocial(obj.getCliRazaoSocial());
		entity.setCliNomeFantasia(obj.getCliNomeFantasia());
		entity.setCliEndereco(obj.getCliEndereco());
		entity.setCliSegmento(obj.getCliSegmento());
		entity.setCliFlag(obj.getCliFlag());
	}
	
}
