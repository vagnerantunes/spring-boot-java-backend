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

	public Boleto findById(Long id) {
		Optional<Boleto> obj = repository.findById(id);
		return obj.get();

	}

	public Boleto insert(Boleto obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Boleto update(Long id, Boleto obj) {
		Boleto entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Boleto entity, Boleto obj) {
		entity.setBOL_CONTAPFPJ(obj.getBOL_CONTAPFPJ());
		entity.setBOL_DATA(obj.getBOL_DATA());
		entity.setBOL_DESCRICAO(obj.getBOL_DESCRICAO());
		entity.setBOL_OBS(obj.getBOL_OBS());
		entity.setBOL_QTDPARCELAS(obj.getBOL_QTDPARCELAS());
		entity.setBOL_VALOR(obj.getBOL_VALOR());
	}
}