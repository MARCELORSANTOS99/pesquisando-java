package com.marcelo.pesquisando.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.services.RespostaService;

@RestController
@RequestMapping(value = "/respostas")
public class RespostaResource {
	
	@Autowired
	private RespostaService service;
	
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

}
