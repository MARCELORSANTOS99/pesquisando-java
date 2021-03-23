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
	
	
	public Resposta insert(Resposta obj) {
		System.out.println(obj);
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		
		repository.deleteById(obj);
	}
	
	public Resposta upDate(Long id, Resposta obj) {
		
		Resposta entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(Resposta entity, Resposta obj) {
		
		entity.setResp(obj.getResp());
	
		
	}


	

}
