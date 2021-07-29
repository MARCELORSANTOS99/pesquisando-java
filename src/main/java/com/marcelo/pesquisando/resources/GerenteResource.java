package com.marcelo.pesquisando.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.pesquisando.entities.Gerente;
import com.marcelo.pesquisando.entities.GerenteApuracao;
import com.marcelo.pesquisando.entities.GerenteApuracaoTipo;
import com.marcelo.pesquisando.entities.Usuario;
import com.marcelo.pesquisando.services.GerenteService;
import com.marcelo.pesquisando.services.UsuarioService;

@Controller
@RestController
@RequestMapping(value = "/gerente")
public class GerenteResource {
	
	
	@Autowired
	private GerenteService service;
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Gerente>> findAll(){
		
		List<Gerente> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Gerente> findById(@PathVariable Long id){
		Gerente obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/firebase/{user}")
	public ResponseEntity<Gerente> findByUserUid(@PathVariable String user){
		System.out.println(user);
		Gerente obj = service.findByUserFirebase(user);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/firebase/totalPesquisas/{idCidade}")
	public ResponseEntity<List<GerenteApuracao>>  qtdPesquisaFeitas(@PathVariable String idCidade){
		
			
		List<GerenteApuracao> listGerenteApuracao = service.totalPesquisasFeitas(idCidade);
			
		 return ResponseEntity.ok().body(listGerenteApuracao);
	}
	
	@GetMapping(value = "/firebase/totalPesquisas/genero/{usuarioNome}/{idCidade}")
	public ResponseEntity<List<GerenteApuracaoTipo>>  qtdPesquisaFeitasGenero(@PathVariable String usuarioNome ,@PathVariable String idCidade){
		
		
		String usuario = pegarUsuario(usuarioNome);
		
		
			
		List<GerenteApuracaoTipo> listGerenteApuracaoPorTipo = service.totalPesquisasFeitasGenero(idCidade, usuario);
			
		 return ResponseEntity.ok().body(listGerenteApuracaoPorTipo);
	}

	public String pegarUsuario(String usuario) {
		
		System.out.println("Pegar User");
		Usuario getUsuario = usuarioService.findByNomeUsuario(usuario);
		
		String user = getUsuario.getEmail();
		return user;
	}
	
	@GetMapping(value = "/firebase/totalPesquisas/idade/{usuarioNome}/{idCidade}")
	public ResponseEntity<List<GerenteApuracaoTipo>>  qtdPesquisaFeitasIdade(@PathVariable String usuarioNome ,@PathVariable String idCidade){
		
		String usuario = pegarUsuario(usuarioNome);
			
		List<GerenteApuracaoTipo> listGerenteApuracaoPorTipo = service.totalPesquisasFeitasIdade(idCidade, usuario);
			
		 return ResponseEntity.ok().body(listGerenteApuracaoPorTipo);
	}
	
	@GetMapping(value = "/firebase/totalPesquisas/religiao/{usuarioNome}/{idCidade}")
	public ResponseEntity<List<GerenteApuracaoTipo>>  qtdPesquisaFeitasReligiao(@PathVariable String usuarioNome ,@PathVariable String idCidade){
		
		String usuario = pegarUsuario(usuarioNome);
			
		List<GerenteApuracaoTipo> listGerenteApuracaoPorTipo = service.totalPesquisasFeitasReligiao(idCidade, usuario);
			
		 return ResponseEntity.ok().body(listGerenteApuracaoPorTipo);
	}
	
	@GetMapping(value = "/firebase/totalPesquisas/escolaridade/{usuarioNome}/{idCidade}")
	public ResponseEntity<List<GerenteApuracaoTipo>>  qtdPesquisaFeitasEscolaridade(@PathVariable String usuarioNome ,@PathVariable String idCidade){
		
		String usuario = pegarUsuario(usuarioNome);
		List<GerenteApuracaoTipo> listGerenteApuracaoPorTipo = service.totalPesquisasFeitasEscolaridade(idCidade, usuario);
			
		 return ResponseEntity.ok().body(listGerenteApuracaoPorTipo);
	}
	
	@GetMapping(value = "/firebase/totalPesquisas/bairro/{usuarioNome}/{idCidade}")
	public ResponseEntity<List<GerenteApuracaoTipo>>  qtdPesquisaFeitasBairro(@PathVariable String usuarioNome ,@PathVariable String idCidade){
		
		String usuario = pegarUsuario(usuarioNome);
		
		List<GerenteApuracaoTipo> listGerenteApuracaoPorTipo = service.totalPesquisasFeitasBairro(idCidade, usuario);
			
		 return ResponseEntity.ok().body(listGerenteApuracaoPorTipo);
	}
	
	
	@GetMapping(value = "/firebase/totalPesquisas/idade/{idCidade}")
	public ResponseEntity<List<GerenteApuracao>>  qtdPesquisaFeitasIdade(@PathVariable String idCidade){
		
			
		List<GerenteApuracao> listGerenteApuracao = service.totalPesquisasFeitas(idCidade);
			
		 return ResponseEntity.ok().body(listGerenteApuracao);
	}
	
	@GetMapping(value = "/firebase/totalPesquisas/religiao/{idCidade}")
	public ResponseEntity<List<GerenteApuracao>>  qtdPesquisaFeitasReligiao(@PathVariable String idCidade){
		
			
		List<GerenteApuracao> listGerenteApuracao = service.totalPesquisasFeitas(idCidade);
			
		 return ResponseEntity.ok().body(listGerenteApuracao);
	}
	
	@GetMapping(value = "/firebase/totalPesquisas/escolaridade/{idCidade}")
	public ResponseEntity<List<GerenteApuracao>>  qtdPesquisaFeitasEscolaridade(@PathVariable String idCidade){
		
			
		List<GerenteApuracao> listGerenteApuracao = service.totalPesquisasFeitas(idCidade);
			
		 return ResponseEntity.ok().body(listGerenteApuracao);
	}
	
	@GetMapping(value = "/firebase/totalPesquisas/bairro/{idCidade}")
	public ResponseEntity<List<GerenteApuracao>>  qtdPesquisaFeitasBairro(@PathVariable String idCidade){
		
			
		List<GerenteApuracao> listGerenteApuracao = service.totalPesquisasFeitas(idCidade);
			
		 return ResponseEntity.ok().body(listGerenteApuracao);
	}
	
	@PostMapping
	public ResponseEntity<Gerente> insert(@RequestBody Gerente obj){
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Gerente> update(@PathVariable Long id, @RequestBody Gerente obj){
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
