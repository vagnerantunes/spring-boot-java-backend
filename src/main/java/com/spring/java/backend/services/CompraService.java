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

	public Compra findById(Integer id) {
		Optional<Compra> obj = repository.findById(id);
		return obj.get();
	}

	public Compra insert(Compra obj) {
		obj.setComId(null);
		obj.setComFornecedor(fornecedorService.findById(obj.getComFornecedor().getForId()));
		obj = repository.save(obj);
		return obj;
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Compra update(Integer id, Compra obj) {
		Compra entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Compra entity, Compra obj) {
		entity.setComData(obj.getComData());
		entity.setComDesconto(obj.getComDesconto());
		entity.setComJuros(obj.getComJuros());
		entity.setCOM_STS_DOC(obj.getCOM_STS_DOC());
		entity.setComValorTotal(obj.getComValorTotal());
		entity.setComFornecedor(obj.getComFornecedor());
		
	}
}
