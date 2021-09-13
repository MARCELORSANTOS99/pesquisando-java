package com.marcelo.pesquisando.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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

import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.entities.User;
import com.marcelo.pesquisando.entities.Usuario;
import com.marcelo.pesquisando.repositories.UserRepository;
import com.marcelo.pesquisando.services.UsuarioService;

@Controller
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	
	@Autowired
	private UsuarioService service;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		
		List<Usuario> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/login/{token}")
	public ResponseEntity<Usuario> findByUID(@PathVariable String token){
				
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		System.out.println("---");
		System.out.println(user.getUsername());
		Usuario obj = service.findByNome(user.getUsername());
		
		System.out.println(token);
		obj = service.upDateLastLogin(obj.getId(), obj,token);
		
		
		Integer perfil = obj.getPerfil();
		System.out.println("Tamanho da lista-> "+obj.getContract().getCidades().size());
		System.out.println("LISTA -> "+obj.getContract().getCidades().toString());
		
		
		
		int tamanhoLista = obj.getContract().getCidades().size();
		
		List<Cidade> listaCidade = new ArrayList<>();
		
		/*
		if(perfil == 2) {
			for (int i = 0; i <= tamanhoLista; i++) {
				System.out.println("tamanhoLista FOR-> "+ tamanhoLista );
				System.out.println("NOME DO CLIENTE-> "+ obj.getContract().getCidades().get(i).getNomeCliente().toString() );
				System.out.println("USER-> "+ user.getUsername().toString() );
				
				System.out.println("TESTE -> "+!obj.getContract().getCidades().get(i).getNomeCliente().toString().equals(user.getUsername().toString()));
				
				if(!obj.getContract().getCidades().get(i).getNomeCliente().toString().equals(user.getUsername().toString()))
					
					//listaCidade.add(obj.getContract().getCidades().get(i));
					listaCidade.remove(i);
					tamanhoLista =-1;
				
					System.out.println("Removido-> "+obj.getContract().getCidades().get(i).getNome());

			
			}
			
			obj.getContract().getCidades().clear();
			obj.getContract().setCidades(listaCidade);
		}
		*/
		
		if(perfil == 2) {
			
		for (Cidade cidade : obj.getContract().getCidades()) {
			
			if(cidade.getNomeCliente().equals(user.getUsername().toString())) {
				listaCidade.add(cidade);
			}
				 
		}
		
		obj.getContract().getCidades().clear();
		obj.getContract().setCidades(listaCidade);
	
		}
		
		return ResponseEntity.ok().body(obj);
	
		
		
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		
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
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario obj){
		System.out.println("UPDATE CIDADE");
		System.out.println(obj.getNome());
		
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
