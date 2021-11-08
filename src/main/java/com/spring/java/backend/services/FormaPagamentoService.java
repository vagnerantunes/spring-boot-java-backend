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

	public FormaPagamento findById(Long id) {
		Optional<FormaPagamento> obj = repository.findById(id);
		return obj.get();
	}

	public FormaPagamento insert(FormaPagamento obj) {
		return repository.save(obj);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public FormaPagamento update(Long id, FormaPagamento obj) {
		FormaPagamento entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(FormaPagamento entity, FormaPagamento obj) {
		entity.setFPG_DESCRICAO(obj.getFPG_DESCRICAO());
		entity.setFPG_FLAG(obj.getFPG_FLAG());
		entity.setFPG_PORCENTAGEM(obj.getFPG_PORCENTAGEM());
		entity.setFPG_QTDPARCELA(obj.getFPG_QTDPARCELA());
		entity.setFPG_TIPO(obj.getFPG_TIPO());
		entity.setFPG_TIPO_CONTA(obj.getFPG_TIPO_CONTA());
	}

}
