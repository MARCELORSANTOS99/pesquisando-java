package com.marcelo.pesquisando.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Gerente;
import com.marcelo.pesquisando.entities.GerenteApuracao;
import com.marcelo.pesquisando.entities.GerenteApuracaoTipo;
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
	
	public List<GerenteApuracaoTipo> totalPesquisasFeitasGenero(String idCidade, String usuario) {
		
		List<String> generos = pesquisaRepository.agruparPorGenero(idCidade);	
		List<GerenteApuracaoTipo> listGerenteApuracao = new ArrayList<GerenteApuracaoTipo>();
		
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		for (String genero : generos) {
			
			List<Object[]> results = pesquisaRepository.totalPesquisaPorUsuarioGenero(usuario, idCidade,genero);
						
			GerenteApuracaoTipo gerenteApuracao = new GerenteApuracaoTipo(
						genero,
						results.size()
					);
				listGerenteApuracao.add(gerenteApuracao);
			
			 
		}
		
		return listGerenteApuracao;
	}
	
	public List<GerenteApuracaoTipo> totalPesquisasFeitasIdade(String idCidade, String usuario) {
		
		List<String> idades = pesquisaRepository.agruparPorIdade(idCidade);	
		List<GerenteApuracaoTipo> listGerenteApuracao = new ArrayList<GerenteApuracaoTipo>();
		
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		for (String idade : idades) {
			
			List<Object[]> results = pesquisaRepository.totalPesquisaPorUsuarioIdade(usuario, idCidade,idade);
						
			GerenteApuracaoTipo gerenteApuracao = new GerenteApuracaoTipo(
						idade,
						results.size()
					);
				listGerenteApuracao.add(gerenteApuracao);
			
			 
		}
		
		return listGerenteApuracao;
	}
	
	public List<GerenteApuracaoTipo> totalPesquisasFeitasReligiao(String idCidade, String usuario) {
		
		List<String> relgioes = pesquisaRepository.agruparPorReligiao(idCidade);	
		List<GerenteApuracaoTipo> listGerenteApuracao = new ArrayList<GerenteApuracaoTipo>();
		
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		for (String relgiao : relgioes) {
			
			List<Object[]> results = pesquisaRepository.totalPesquisaPorUsuarioReligiao(usuario, idCidade,relgiao);
						
			GerenteApuracaoTipo gerenteApuracao = new GerenteApuracaoTipo(
						relgiao,
						results.size()
					);
				listGerenteApuracao.add(gerenteApuracao);
			
			 
		}
		
		return listGerenteApuracao;
	}
	
	public List<GerenteApuracaoTipo> totalPesquisasFeitasEscolaridade(String idCidade, String usuario) {
		
		List<String> escolaridades = pesquisaRepository.agruparPorEscolaridade(idCidade);	
		List<GerenteApuracaoTipo> listGerenteApuracao = new ArrayList<GerenteApuracaoTipo>();
		
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		for (String escolaridade : escolaridades) {
			
			List<Object[]> results = pesquisaRepository.totalPesquisaPorUsuarioEscolaridade(usuario, idCidade,escolaridade);
						
			GerenteApuracaoTipo gerenteApuracao = new GerenteApuracaoTipo(
						escolaridade,
						results.size()
					);
				listGerenteApuracao.add(gerenteApuracao);
			
			 
		}
		
		return listGerenteApuracao;
	}
	
	public List<GerenteApuracaoTipo> totalPesquisasFeitasBairro(String idCidade, String usuario) {
		
		List<String> bairros = pesquisaRepository.agruparPorCidadeBairro(idCidade);	
		List<GerenteApuracaoTipo> listGerenteApuracao = new ArrayList<GerenteApuracaoTipo>();
		
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		for (String bairro : bairros) {
			
			List<Object[]> results = pesquisaRepository.totalPesquisaPorUsuarioBairro(usuario, idCidade,bairro);
						
			GerenteApuracaoTipo gerenteApuracao = new GerenteApuracaoTipo(
						bairro,
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
