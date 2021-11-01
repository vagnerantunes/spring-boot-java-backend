package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.backend.entities.Cliente;
import com.spring.java.backend.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();

	}

	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Cliente update(Long id, Cliente obj) {
		Cliente entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setCLI_NOME(obj.getCLI_NOME());
		entity.setCLI_TIPO(obj.getCLI_TIPO());
		entity.setCLI_CPFCNPJ(obj.getCLI_CPFCNPJ());
		entity.setCLI_DATANASCIMENTO(obj.getCLI_DATANASCIMENTO());
		entity.setCLI_CONTATO(obj.getCLI_CONTATO());
		entity.setCLI_EMAIL(obj.getCLI_EMAIL());
		entity.setCLI_RAZAOSOCIAL(obj.getCLI_RAZAOSOCIAL());
		entity.setCLI_NOMEFANTASIA(obj.getCLI_NOMEFANTASIA());
		entity.setCLI_ENDERECO(obj.getCLI_ENDERECO());
		entity.setCLI_SEGMENTO(obj.getCLI_SEGMENTO());
		entity.setCLI_FLAG(obj.getCLI_FLAG());
	}
}
