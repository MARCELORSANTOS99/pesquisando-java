package com.marcelo.pesquisando.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.pesquisando.entities.User;
import com.marcelo.pesquisando.services.UserService;

@Controller
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	
	@Autowired
	private UserService service;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	
	
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getUsername()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	
	@PutMapping(value = "/update")
	public ResponseEntity<User> update(@RequestBody User obj){
		
		
		obj = service.upDate("", obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
