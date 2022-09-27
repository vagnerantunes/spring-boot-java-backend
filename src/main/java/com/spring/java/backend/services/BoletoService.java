package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.backend.entities.Boleto;
import com.spring.java.backend.repositories.BoletoRepository;

@Service
public class BoletoService {

	@Autowired
	public BoletoRepository repository;

	public List<Boleto> findAll() {
		return repository.findAll();
	}

	public Boleto findById(Integer id) {
		Optional<Boleto> obj = repository.findById(id);
		return obj.get();

	}

	public Boleto insert(Boleto obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Boleto update(Integer id, Boleto obj) {
		Boleto entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Boleto entity, Boleto obj) {
		entity.setBolContaPFPJ(obj.getBolContaPFPJ());
		entity.setBolData(obj.getBolData());
		entity.setBolDescricao(obj.getBolDescricao());
		entity.setBolObs(obj.getBolObs());
		entity.setBolQtdParcelas(obj.getBolQtdParcelas());
		entity.setBolValor(obj.getBolValor());
	}
}