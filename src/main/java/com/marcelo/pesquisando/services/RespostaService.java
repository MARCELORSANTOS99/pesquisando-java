package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.repositories.RespostaRepository;

@Service
public class RespostaService {
	
	@Autowired
	private RespostaRepository repository;
	
	public List<Resposta> findAll(){
		return repository.findAll();
	}
	
	public Resposta findById(Long id) {
		Optional<Resposta> obj =  repository.findById(id);
		return obj.get();
	}
	
	

}
