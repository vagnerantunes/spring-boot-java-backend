package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.backend.entities.Produto;
import com.spring.java.backend.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}

	public Produto insert(Produto obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Produto update(Long id, Produto obj) {
		Produto entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Produto entity, Produto obj) {
		entity.setPRO_DESCRICAO(obj.getPRO_DESCRICAO());
		entity.setPRO_ESTOQUE(obj.getPRO_ESTOQUE());
		entity.setPRO_ESTVENDIDO(obj.getPRO_ESTVENDIDO());
		entity.setPRO_FLAG(obj.getPRO_FLAG());
		entity.setPRO_PRECOCUSTO(obj.getPRO_PRECOCUSTO());
		entity.setPRO_PRECOVENDA(obj.getPRO_PRECOVENDA());
	}

}
