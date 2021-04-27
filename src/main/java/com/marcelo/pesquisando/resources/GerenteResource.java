package com.marcelo.pesquisando.resources;

import java.net.URI;
import java.util.List;

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

import com.marcelo.pesquisando.entities.Gerente;
import com.marcelo.pesquisando.services.GerenteService;

@Controller
@RestController
@RequestMapping(value = "/gerente")
public class GerenteResource {
	
	
	@Autowired
	private GerenteService service;
	
	@GetMapping
	public ResponseEntity<List<Gerente>> findAll(){
		
		List<Gerente> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Gerente> findById(@PathVariable Long id){
		Gerente obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/firebase/{user}")
	public ResponseEntity<Gerente> findByUserUid(@PathVariable String user){
		System.out.println(user);
		Gerente obj = service.findByUserFirebase(user);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Gerente> insert(@RequestBody Gerente obj){
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Gerente> update(@PathVariable Long id, @RequestBody Gerente obj){
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
