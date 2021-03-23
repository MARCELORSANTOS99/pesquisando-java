package com.marcelo.pesquisando.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Entrevistado;
import com.marcelo.pesquisando.services.EntrevistadoService;

@RestController
@RequestMapping(value = "/entrevistados")
public class EntrevistadoResource {
	
	@Autowired
	private EntrevistadoService service;
	
	@GetMapping
	public ResponseEntity<List<Entrevistado>> findAll(){
		
		List<Entrevistado> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Entrevistado> findById(@PathVariable Long id){
		Entrevistado obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Entrevistado> insert(@RequestBody Entrevistado obj){
		
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
	public ResponseEntity<Entrevistado> update(@PathVariable Long id, @RequestBody Entrevistado obj){
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
