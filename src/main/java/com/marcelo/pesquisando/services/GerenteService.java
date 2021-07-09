package com.marcelo.pesquisando.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Gerente;
import com.marcelo.pesquisando.entities.GerenteApuracao;
import com.marcelo.pesquisando.entities.User;
import com.marcelo.pesquisando.entities.Usuario;
import com.marcelo.pesquisando.repositories.GerenteRepository;
import com.marcelo.pesquisando.repositories.PesquisaRepository;
import com.marcelo.pesquisando.repositories.UserRepository;
import com.marcelo.pesquisando.repositories.UsuarioRepository;

@Service
public class GerenteService {
	
	@Autowired
	private GerenteRepository repository;
	
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	
	@Autowired
	private UserRepository userRepository;
	
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
	
	
	public List<GerenteApuracao> totalPesquisasFeitas(String idCidade) {
				
		List<Usuario> ListGerente = UsuarioRepository.findAll();
		List<GerenteApuracao> listGerenteApuracao = new ArrayList<GerenteApuracao>();
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		for (Usuario usuario : ListGerente) {
			
			List<Object[]> results = pesquisaRepository.totalPesquisaPorUsuario(usuario.getEmail(), idCidade);
			System.out.println(usuario.getEmail());
			
				GerenteApuracao gerenteApuracao = new GerenteApuracao(
						usuario.getNome(),
						usuario.getEmail(),
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
