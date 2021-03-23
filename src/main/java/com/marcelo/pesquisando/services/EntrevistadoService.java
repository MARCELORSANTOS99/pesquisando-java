package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Entrevistado;
import com.marcelo.pesquisando.repositories.EntrevistadoRepository;

@Service
public class EntrevistadoService {
	
	@Autowired
	private EntrevistadoRepository repository;
	
	public List<Entrevistado> findAll(){
		return repository.findAll();
	}
	
	public Entrevistado findById(Long id) {
		Optional<Entrevistado> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Entrevistado insert(Entrevistado obj) {
		System.out.println(obj);
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		
		repository.deleteById(obj);
	}
	
	public Entrevistado upDate(Long id, Entrevistado obj) {
		
		Entrevistado entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(Entrevistado entity, Entrevistado obj) {
		
		entity.setNome(obj.getNome());;
	
		
	}


	

}
