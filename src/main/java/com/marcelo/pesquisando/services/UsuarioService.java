package com.marcelo.pesquisando.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Usuario;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id) {
		//OrderBySeatNumberAsc()
		Optional<Usuario> obj =  repository.findById(id);
		return obj.get();
	}
	
	public Usuario findByNome(String nomeUser) {
		
		System.out.println(nomeUser);
		Optional<Usuario> obj =  repository.findByEmail(nomeUser);
		
		Integer perfil = obj.get().getPerfil();
		
		if(perfil == 2) {
			for (int i = 0; i <  obj.get().getContract().getCidades().size(); i++) {
				if(obj.get().getContract().getCidades().get(i).getNomeCliente().equals(nomeUser)) 
					obj.get().getContract().getCidades().remove(i);
			}
		}
		
		return obj.get();
	}
	
	public Usuario findByNomeUsuario(String nomeUser) {
		
		System.out.println(nomeUser);
		Optional<Usuario> obj =  repository.findByNome(nomeUser);
		return obj.get();
	}
	
	
	public Usuario insert(Usuario obj) {
		System.out.println(obj.getNome());
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		
		repository.deleteById(obj);
	}
	
	public Usuario upDate(Long id, Usuario obj) {
		
		Usuario entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}
	
	public Usuario upDateLastLogin(Long id, Usuario obj) {
		
    	
		Usuario entity = repository.getOne(id);
		updateDataLastLogin(entity);
		
		return repository.save(entity);
	}

	private void updateData(Usuario entity, Usuario obj) {
		
		entity.setNome(obj.getNome());;
	
		
	}
	
private void updateDataLastLogin(Usuario entity) {
	
    	Instant moment = Instant.now();
	
		entity.setLastLogin(moment);	
		
	}


	

}
