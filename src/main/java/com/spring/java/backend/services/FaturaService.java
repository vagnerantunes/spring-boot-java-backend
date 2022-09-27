package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.java.backend.entities.Fatura;
import com.spring.java.backend.repositories.FaturaRepository;

@Service
public class FaturaService {

	@Autowired
	private FaturaRepository repository;

	@Autowired
	private FormaPagamentoService formaPagamentoService;

	public List<Fatura> findAll() {
		return repository.findAll();
	}

	public Fatura findById(Integer id) {
		Optional<Fatura> obj = repository.findById(id);
		return obj.get();
	}

	public void delete(Integer id) {
		repository.deleteById(id);

	}

	public Fatura insert(Fatura obj) {
		obj.setFatId(null);
		obj.setFatPagamento(formaPagamentoService.findById(obj.getFatPagamento().getFpgId()));
		obj = repository.save(obj);
		return obj;
	}

	@SuppressWarnings("deprecation")
	public Fatura update(Integer id, Fatura obj) {
		Fatura entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Fatura entity, Fatura obj) {
		entity.setFatDataLancamento(obj.getFatDataLancamento());
		entity.setFatDesconto(obj.getFatDesconto());
		entity.setFatJuros(obj.getFatJuros());
		entity.setFAT_STS_PAG(obj.getFAT_STS_PAG());
		entity.setFatValorPago(obj.getFatValorPago());
		entity.setFatValorTotal(obj.getFatValorTotal());
		entity.setFatVencimento(obj.getFatVencimento());
		entity.setFatAtraso(obj.getFatAtraso());
		entity.setFatPagamento(obj.getFatPagamento());
	}
}