package com.marcelo.pesquisando.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.entities.Usuario;
import com.marcelo.pesquisando.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	@Autowired
	private UsuarioService UsuarioService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PerguntaService perguntaService;
	
	public List<Cidade> findAll(){
		return repository.findAll();
	}
	
	public Cidade findById(Long id) {
		//OrderBySeatNumberAsc()
		Optional<Cidade> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Cidade insert(Cidade obj) {
		
		System.out.println(obj.getNome());
		System.out.println(userService.userLogado());
		
		Usuario user = UsuarioService.findByNome(userService.userLogado());
		
		obj.setContract(user.getContract());
		
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		
		Cidade c = findById(obj);
		System.out.println(userService.userLogado());
	
		List<Pergunta> perguntas = c.getPerguntas();
	
		for (Pergunta pergunta : perguntas) {
			perguntaService.delete(pergunta.getId());
			
		}
		
		repository.deleteById(obj);
	}
	
	public Cidade upDate(Long id, Cidade obj) {
	
		System.out.println(userService.userLogado());
	

		
		Cidade entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(Cidade entity, Cidade obj) {

		
		entity.setNome(obj.getNome());;
	
		
	}


	

}
