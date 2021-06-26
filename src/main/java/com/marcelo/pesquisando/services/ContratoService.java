package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.entities.Contrato;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.repositories.ContratoRepository;

@Service
public class ContratoService {
	
	@Autowired
	private ContratoRepository repository;
	
	@Autowired
	private PerguntaService perguntaService;
	
	public List<Contrato> findAll(){
		return repository.findAll();
	}
	
	public Contrato findById(Long id) {
		//OrderBySeatNumberAsc()
		Optional<Contrato> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Contrato insert(Contrato obj) {
		System.out.println(obj.getNome());
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		
		Contrato c = findById(obj);
	
		List<Cidade> cidades = c.getCidades();
	
		for (Cidade cidade : cidades) {
			perguntaService.delete(cidade.getId());
			
		}
		
		repository.deleteById(obj);
	}
	
	public Contrato upDate(Long id, Contrato obj) {
		
		Contrato entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(Contrato entity, Contrato obj) {
		
		entity.setNome(obj.getNome());;
	
		
	}


	

}
