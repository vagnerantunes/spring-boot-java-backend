package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.backend.entities.Compra;
import com.spring.java.backend.repositories.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository repository;

	@Autowired
	private FornecedorService fornecedorService;

	public List<Compra> findAll() {
		return repository.findAll();
	}

	public Compra findById(Long id) {
		Optional<Compra> obj = repository.findById(id);
		return obj.get();
	}

	public Compra insert(Compra obj) {
		obj.setCOM_ID(null);
		obj.setFornecedor(fornecedorService.findById(obj.getFornecedor().getFOR_ID()));
		obj = repository.save(obj);
		return obj;

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Compra update(Long id, Compra obj) {
		Compra entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Compra entity, Compra obj) {
		entity.setCOM_DATA(obj.getCOM_DATA());
		entity.setCOM_DESCONTO(obj.getCOM_DESCONTO());
		entity.setCOM_JUROS(obj.getCOM_JUROS());
		entity.setCOM_STS_DOC(obj.getCOM_STS_DOC());
		entity.setCOM_VALORTOTAL(obj.getCOM_VALORTOTAL());
		entity.setFornecedor(obj.getFornecedor());
	}
}
