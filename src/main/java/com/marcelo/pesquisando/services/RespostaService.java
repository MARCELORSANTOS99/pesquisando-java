package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.repositories.RespostaRepository;

@Service
public class RespostaService {
	
	@Autowired
	private RespostaRepository repository;
	
	public List<Resposta> findAll(){
		
		return repository.findAllByOrderByIdAsc();
	}
	
	public Resposta findById(Long id) {
		Optional<Resposta> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Resposta insert(Resposta obj) {
		return repository.save(obj);
	}
	
	public Resposta insertFromApp(Resposta obj, Pergunta pergunt ) {
		obj.setPergunt(pergunt);
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		
		List<Resposta> respostas = findAll();

		long toConvertObj = obj;//3
		int id = (int)toConvertObj;
			
		int idPergunta = (int) toConvertObj;
			
		for (int i = 0; i < respostas.size(); i++) {
			
			long idRespostaPraDeletar = respostas.get(i).getId();//2
			long idPerguntaNaResposta = respostas.get(i).getPergunt().getId();//2
			
			System.out.println("idRespostaPraDeletar "+ idRespostaPraDeletar);
			System.out.println("idPerguntaNaResposta "+ idPerguntaNaResposta);
			System.out.println("idPergunta "+ idPergunta);
			
			if (idPerguntaNaResposta == toConvertObj) {//2=2
				repository.deleteById(idRespostaPraDeletar);	
			}
		}
		
		
	}
	
	public void deleteFromApp(Long id) {
		
		repository.deleteById(id);
		System.out.println("Resposta deletada");
		
	}
	
	public Resposta upDate(Long id, Resposta obj) {
		System.out.println("<<<EDIT RESPOSTAS>>>");
		System.out.println(id);
		System.out.println(obj);
		System.out.println(obj.getId());
		System.out.println(obj.getResp());
		
		Resposta entity = repository.getOne(id);
		updateData(entity,obj);
		
		System.out.println("Salvou novas respostas");
		return repository.save(entity);
	}

	private void updateData(Resposta entity, Resposta obj) {
		
		entity.setResp(obj.getResp());
	
		
	}


	

}
