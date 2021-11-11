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

	public Fatura findById(Long id) {
		Optional<Fatura> obj = repository.findById(id);
		return obj.get();
	}

	public void delete(Long id) {
		repository.deleteById(id);

	}

	public Fatura insert(Fatura obj) {
		obj.setFAT_ID(null);
		obj.setPagamentos(formaPagamentoService.findById(obj.getPagamentos().getFPG_ID()));
		obj = repository.save(obj);
		return obj;
	}

	@SuppressWarnings("deprecation")
	public Fatura update(Long id, Fatura obj) {
		Fatura entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Fatura entity, Fatura obj) {
		entity.setFAT_DATALANCEMENTO(obj.getFAT_DATALANCEMENTO());
		entity.setFAT_DESCONTO(obj.getFAT_DESCONTO());
		entity.setFAT_JUROS(obj.getFAT_JUROS());
		entity.setFAT_STS_PAG(obj.getFAT_STS_PAG());
		entity.setFAT_VALORPAGO(obj.getFAT_VALORPAGO());
		entity.setFAT_VALORTOTAL(obj.getFAT_VALORTOTAL());
		entity.setFAT_VENCIMENTO(obj.getFAT_VENCIMENTO());
		entity.setFAT_ATRASO(obj.getFAT_ATRASO());
		entity.setPagamentos(obj.getPagamentos());
	}
}