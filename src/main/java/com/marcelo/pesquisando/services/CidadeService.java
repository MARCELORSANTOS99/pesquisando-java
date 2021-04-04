package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> findAll(){
		return repository.findAll();
	}
	
	public Cidade findById(Long id) {
		Optional<Cidade> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Cidade insert(Cidade obj) {
		System.out.println(obj.getNome());
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		
		repository.deleteById(obj);
	}
	
	public Cidade upDate(Long id, Cidade obj) {
		
		Cidade entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(Cidade entity, Cidade obj) {
		
		entity.setNome(obj.getNome());;
	
		
	}


	

}