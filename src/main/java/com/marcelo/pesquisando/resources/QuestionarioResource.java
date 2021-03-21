package com.marcelo.pesquisando.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.pesquisando.entities.Questionario;
import com.marcelo.pesquisando.entities.Resposta;

@RestController
@RequestMapping(value = "/questionario")
public class QuestionarioResource {
	
	@GetMapping
	public ResponseEntity<Questionario> findAll(){
		Questionario q = new Questionario(null,null);
		 return ResponseEntity.ok().body(q);
	}

}
