package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.repositories.PerguntaRepository;

@Service
public class PerguntaService {
	
	@Autowired
	private PerguntaRepository repository;
	
	public List<Pergunta> findAll(){
		return repository.findAll();
	}
	
	public Pergunta findById(Long id) {
		Optional<Pergunta> obj =  repository.findById(id);
		return obj.get();
	}
	
	public Pergunta insert(Pergunta obj) {
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		
		repository.deleteById(obj);
	}
	
	public Pergunta upDate(Long id, Pergunta obj) {
		
		Pergunta entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(Pergunta entity, Pergunta obj) {
		entity.setQuestion(obj.getQuestion());
		
	}
	
	
	

}
