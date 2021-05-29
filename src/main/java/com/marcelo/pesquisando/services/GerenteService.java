package com.marcelo.pesquisando.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Gerente;
import com.marcelo.pesquisando.entities.GerenteApuracao;
import com.marcelo.pesquisando.repositories.GerenteRepository;
import com.marcelo.pesquisando.repositories.PesquisaRepository;

@Service
public class GerenteService {
	
	@Autowired
	private GerenteRepository repository;
	
	@Autowired
	private PesquisaRepository pesquisaRepository;
	
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
	
	
	public List<GerenteApuracao> totalPesquisasFeitas() {
				
		List<Gerente> ListGerente = repository.findAll();
		List<GerenteApuracao> listGerenteApuracao = new ArrayList<GerenteApuracao>();
		
		for (Gerente gerente : ListGerente) {
			
			List<Object[]> results = pesquisaRepository.totalPesquisaPorUsuario(gerente.getNome());	
			//System.out.println(results.size());
			
				GerenteApuracao gerenteApuracao = new GerenteApuracao(
						gerente.getUserFirebase(),
						gerente.getNome(),
						gerente.getEmail(),
						results.size()
					);
				listGerenteApuracao.add(gerenteApuracao);
			
			 
		}
		
		return listGerenteApuracao;
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
