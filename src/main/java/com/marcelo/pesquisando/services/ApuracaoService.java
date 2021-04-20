package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Apuracao;
import com.marcelo.pesquisando.repositories.ApuracaoRepository;

@Service
public class ApuracaoService {
	
	@Autowired
	private ApuracaoRepository repository;
	
	public List<Apuracao> findAll(){
		return repository.findAll();
	}
	
	public Apuracao findById(Long id) {
		Optional<Apuracao> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Apuracao insert(Apuracao obj) {
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		
		repository.deleteById(obj);
	}
	
	public Apuracao upDate(Long id, Apuracao obj) {
		
		Apuracao entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(Apuracao entity, Apuracao obj) {
		
		//entity.setNome(obj.getNome());;
	
		
	}


	

}
