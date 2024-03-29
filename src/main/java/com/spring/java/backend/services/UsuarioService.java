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

	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}

	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Usuario update(Integer id, Usuario obj) {
		Usuario entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);		
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setUsuNome(obj.getUsuNome());
		entity.setUsuFlag(obj.getUsuFlag());
		entity.setUsuSenha(obj.getUsuSenha());		
	}

}