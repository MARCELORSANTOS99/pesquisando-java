package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.repositories.PesquisaRepository;

@Service
public class PesquisaService {
	
	@Autowired
	private PesquisaRepository repository;
	
	public List<Pesquisa> findAll(){
		
		return repository.findAll();
	}
	
	public Pesquisa findById(Long id) {
		Optional<Pesquisa> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Pesquisa insert(Pesquisa obj) {
		System.out.println(obj);
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		repository.deleteById(obj);
	}
	
	public Pesquisa upDate(Long id, Pesquisa obj) {
		
		Pesquisa entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(Pesquisa entity, Pesquisa obj) {
		
		entity.setCidade(obj.getCidade());
			
	}
	
	public long buscaPesquisa(String resposta){
		
		return repository.resumo(resposta);
	}
	
	//Exporta para CSV
	


	

}
