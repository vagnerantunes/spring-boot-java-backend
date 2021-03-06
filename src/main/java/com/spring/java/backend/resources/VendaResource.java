package com.spring.java.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.java.backend.entities.Venda;
import com.spring.java.backend.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {

	@Autowired
	private VendaService service;

	@GetMapping
	public ResponseEntity<List<Venda>> findAll() {
		List<Venda> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Venda> findById(@PathVariable Long id) {
		Venda obj = service.findById(id);
		return ResponseEntity.ok().body(obj);

	}
	/*
	 * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<Void>
	 * insert(@Validated @RequestBody Venda obj){ obj = service.insert(obj); URI uri
	 * = ServletUriComponentsBuilder.fromCurrentRequest()
	 * .path("/{id}").buildAndExpand(obj.getVEN_ID()).toUri(); return
	 * ResponseEntity.created(uri).build(); }
	 */

	@PostMapping
	public ResponseEntity<Venda> insert(@RequestBody Venda obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Venda> update(@PathVariable Long id, @RequestBody Venda obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);		
	}

}
