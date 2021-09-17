package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.repositories.PerguntaRepository;

@Service
public class PerguntaService {
	
	@Autowired
	private PerguntaRepository repository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RespostaService respService;
	
	
	
	public List<Pergunta> findAll(){
		
		return repository.findAllByOrderByIdAsc();
	}
	
	public Pergunta findById(Long id) {
		Optional<Pergunta> obj =  repository.findById(id);
		return obj.get();
	}
	
	public Pergunta insert(Pergunta obj) {
		
		Pergunta objToSave = repository.save(obj);
		System.out.println(userService.userLogado());
		
		List<Resposta> resps = objToSave.getRespostas();
		
		for (int i = 0; i < resps.size(); i++) {
		Resposta resposta = new Resposta(null,resps.get(i).getResp(),objToSave);
		
		respService.insert(resposta);					
		}
		
		return objToSave;
	}
	
	public void delete(Long obj) {
	
		System.out.println("<<Delete Respostas>>");
		Pergunta p = findById(obj);
		List<Resposta> respostas = p.getRespostas();
		
		System.out.println("<<ENTROU Delete Respostas>>");
		for (Resposta resposta : respostas) {
			
			respService.deleteFromApp(resposta.getId());
			
		}
		
		repository.deleteById(obj);
	}
	
	public Pergunta upDate(Long id, Pergunta obj) {
		
		Pergunta entity = repository.getOne(id);
		updateData(entity,obj);
					
		
		return repository.save(entity);
		
	}

	private void updateData(Pergunta entity, Pergunta obj) {
		entity.setQuestion(obj.getQuestion());
		entity.setRespostasAleatorias(obj.getRespostasAleatorias());
		entity.setRespostaEspontanea(obj.getRespostaEspontanea());
		entity.setNotificacao(obj.getNotificacao());
		
	}
	

	
	
	

}
