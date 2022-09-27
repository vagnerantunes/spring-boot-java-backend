package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.backend.entities.FormaPagamento;
import com.spring.java.backend.repositories.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository repository;

	public List<FormaPagamento> findAll() {
		return repository.findAll();
	}

	public FormaPagamento findById(Integer id) {
		Optional<FormaPagamento> obj = repository.findById(id);
		return obj.get();
	}

	public FormaPagamento insert(FormaPagamento obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public FormaPagamento update(Integer id, FormaPagamento obj) {
		FormaPagamento entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(FormaPagamento entity, FormaPagamento obj) {
		entity.setFpgDescricao(obj.getFpgDescricao());
		entity.setFpgFlag(obj.getFpgFlag());
		entity.setFpgPorcentagem(obj.getFpgPorcentagem());
		entity.setFpgQtdParcela(obj.getFpgQtdParcela());
		entity.setFpgTipo(obj.getFpgTipo());
		entity.setFpgTipoConta(obj.getFpgTipoConta());
	}
}