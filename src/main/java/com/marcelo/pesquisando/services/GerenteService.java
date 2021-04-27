package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Gerente;
import com.marcelo.pesquisando.repositories.GerenteRepository;

@Service
public class GerenteService {
	
	@Autowired
	private GerenteRepository repository;
	
	public List<Gerente> findAll(){
		return repository.findAll();
	}
	
	public Gerente findById(Long id) {
		Optional<Gerente> obj =  repository.findById(id);
		return obj.get();
	}
	
	public Gerente findByUserFirebase(String userFirebase) {
		Optional<Gerente> obj =  repository.findByUserFirebase(userFirebase);
		return obj.get();
	}
	
	
	public Gerente insert(Gerente obj) {
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		
		repository.deleteById(obj);
	}
	
	public Gerente upDate(Long id, Gerente obj) {
		
		Gerente entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(Gerente entity, Gerente obj) {
		
		entity.setEmail(obj.getEmail());
		entity.setManager(obj.getManager());
		entity.setUserFirebase(obj.getUserFirebase());
	
		
	}


	

}
