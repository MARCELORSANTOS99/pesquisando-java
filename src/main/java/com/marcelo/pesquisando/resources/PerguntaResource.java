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
import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.services.PerguntaService;
import com.marcelo.pesquisando.services.RespostaService;

@RestController
@RequestMapping(value = "/perguntas")
public class PerguntaResource {
	
	
	@Autowired
	private PerguntaService service;
	
	@Autowired
	private RespostaService RespService;
	

	@GetMapping
	public ResponseEntity<List<Pergunta>> findAll(){
		
		List<Pergunta> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pergunta> findById(@PathVariable Long id){
		Pergunta obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Pergunta> insert(@RequestBody Pergunta obj){
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
	public ResponseEntity<Pergunta> update(@PathVariable Long id, @RequestBody Pergunta obj){
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	
	
	
}