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
@RequestMapping(value = "/respostas")
public class RespostaResource {
	
	@Autowired
	private RespostaService service;
	
	@Autowired
	private PerguntaService perguntaService;
	
	@GetMapping
	public ResponseEntity<List<Resposta>> findAll(){
		
		List<Resposta> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Resposta> findById(@PathVariable Long id){
		Resposta obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Resposta> insert(@RequestBody Resposta obj){
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Resposta> insertFromApp(@RequestBody Resposta obj, @PathVariable Long id){
		
		System.out.println("insertFromApp");
		Pergunta pergunta = perguntaService.findById(id);
		System.out.println(pergunta.getId());
		
		obj = service.insertFromApp(obj, pergunta);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
				
		//service.delete(id);
		service.deleteFromApp(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/from/app/{id}")
	public ResponseEntity<Resposta> deleteFromApp(@RequestBody Resposta obj, @PathVariable Long id){
		
		service.deleteFromApp(id);
				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Resposta> update(@PathVariable Long id, @RequestBody Resposta obj){
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
