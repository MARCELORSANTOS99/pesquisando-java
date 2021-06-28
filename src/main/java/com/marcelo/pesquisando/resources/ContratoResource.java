package com.marcelo.pesquisando.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.pesquisando.entities.Contrato;
import com.marcelo.pesquisando.services.ContratoService;

@Controller
@RestController
@RequestMapping(value = "/contratos")
public class ContratoResource {
	
	
	@Autowired
	private ContratoService service;

	/*
	@GetMapping
	public ResponseEntity<List<Contrato>> findAll(){
		
		List<Contrato> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	*/
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contrato> findById(@PathVariable Long id){
		Contrato obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Contrato> insert(@RequestBody Contrato obj){
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		System.out.println("<<Delete CIDADE>>");
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contrato> update(@PathVariable Long id, @RequestBody Contrato obj){
		System.out.println("UPDATE CIDADE");
		System.out.println(obj.getNome());
		
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
