package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.backend.entities.Usuario;
import com.spring.java.backend.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}

	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Usuario update(Long id, Usuario obj) {
		Usuario entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);		

	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setUSU_NOME(obj.getUSU_NOME());
		entity.setUSU_FLAG(obj.getUSU_FLAG());
		entity.setUSU_SENHA(obj.getUSU_SENHA());
		
	}

}
