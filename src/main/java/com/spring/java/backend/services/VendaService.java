package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.backend.dto.VendaDTO;
import com.spring.java.backend.dto.VendaNewDTO;
import com.spring.java.backend.entities.Cliente;
import com.spring.java.backend.entities.FormaPagamento;
import com.spring.java.backend.entities.Usuario;
import com.spring.java.backend.entities.Venda;
import com.spring.java.backend.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;

	//listar todos
	public List<Venda> findAll() {
		return repository.findAll();
	}

	//listar por id
	public Venda findById(Integer id) {
		Optional<Venda> obj = repository.findById(id);
		return obj.get();
	}
	
	public Venda insert (VendaNewDTO vendaNewDTO) {
		Venda venda = fromDTO(vendaNewDTO);
		repository.save(venda);
		return venda;
	}
	
	
	public void delete(Integer id) {
		Optional<Venda> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		repository.deleteById(id);
	}
	
	
	public void update (Integer id, VendaDTO vendaDTO) {
		Venda venda = fromDTO(vendaDTO);
		Optional<Venda> opt = repository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Funcionario não encontrado!, ID: " + id));
		
		venda.setVenId(id);
		repository.save(venda);
	}
	
	//utilitarios
	public Venda fromDTO(VendaNewDTO venNewDTO) {
		Cliente cliente = new Cliente(venNewDTO.getVenCliente(), null, null, null, null, null, null, null, null,
				null, null, null);
		FormaPagamento formaPagamento = new FormaPagamento(venNewDTO.getVenFormaPagamento(), null, null, null, null, 
				null, null);
		Usuario usuario = new Usuario(venNewDTO.getVenUsuario(), null, null, null);
		Venda venda = new Venda(null, venNewDTO.getVenData(), venNewDTO.getVenVrtotal(), venNewDTO.getVenVrpago(), 
				venNewDTO.getVenDesconto(), venNewDTO.getVenJuros(), venNewDTO.getVEN_STS_ORC(), 
				venNewDTO.getVEN_STS_PAG(), cliente, formaPagamento, usuario);
		
		return venda;
	}
	
	public Venda fromDTO(VendaDTO venDTO) {
		Cliente cliente = new Cliente(venDTO.getVenCliente(), null, null, null, null, null, null, null, null,
				null, null, null);
		FormaPagamento formaPagamento = new FormaPagamento(venDTO.getVenFormaPagamento(), null, null, null, null, 
				null, null);
		Usuario usuario = new Usuario(venDTO.getVenUsuario(), null, null, null);
		Venda venda = new Venda(null, venDTO.getVenData(), venDTO.getVenVrtotal(), venDTO.getVenVrpago(), 
				venDTO.getVenDesconto(), venDTO.getVenJuros(), venDTO.getVEN_STS_ORC(), 
				venDTO.getVEN_STS_PAG(), cliente, formaPagamento, usuario);
		
		return venda;
	}
}