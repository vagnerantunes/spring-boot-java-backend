package com.spring.java.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.backend.entities.Venda;
import com.spring.java.backend.repositories.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private FormaPagamentoService formaPagamentoService;

	public List<Venda> findAll() {
		return repository.findAll();
	}

	public Venda findById(Long id) {
		Optional<Venda> obj = repository.findById(id);
		return obj.get();

	}

	/*
	 * Para inserir uma chave estrangeira, verifica se contem na classe entity no
	 * atributo de vendas, "jasonignore" e getter e setter na classe entity
	 * estrangeira.
	 * 
	 */
	public Venda insert(Venda obj) {
		obj.setVEN_ID(null);
		obj.setClientes(clienteService.findById(obj.getClientes().getCLI_ID()));
		obj.setUsuarios(usuarioService.findById(obj.getUsuarios().getUSU_ID()));
		obj.setPagamentos(formaPagamentoService.findById(obj.getPagamentos().getFPG_ID()));
		obj = repository.save(obj);
		return obj;
	}

	/*
	 * este metodo foi substituido pois estava dando inconsistencia... ao inves de
	 * salvar o id informado da chave estrageira, gera em ordem.. ex.: 1,2,3...
	 * 
	 * @Transactional public Venda insert(Venda obj) { obj.setVEN_ID(null);
	 * clienteRepository.save(obj.getClientes()); obj = repository.save(obj); return
	 * obj; }
	 */

	public void delete(Long id) {
		repository.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	public Venda update(Long id, Venda obj) {
		Venda entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Venda entity, Venda obj) {
		entity.setVEN_DATA(obj.getVEN_DATA());
		entity.setVEN_DESCONTO(obj.getVEN_DESCONTO());
		entity.setVEN_JUROS(obj.getVEN_JUROS());
		entity.setVEN_STS_ORC(obj.getVEN_STS_ORC());
		entity.setVEN_STS_PAG(obj.getVEN_STS_PAG());
		entity.setVEN_VRPAGO(obj.getVEN_VRPAGO());
		entity.setVEN_VRTOTAL(obj.getVEN_VRTOTAL());	
		entity.setClientes(obj.getClientes());
		entity.setPagamentos(obj.getPagamentos());
		entity.setUsuarios(obj.getUsuarios());
		
	}

}