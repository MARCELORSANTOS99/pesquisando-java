package com.marcelo.pesquisando.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Apuracao;
import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.entities.LatLongPesquisa;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.entities.User;
import com.marcelo.pesquisando.entities.Usuario;
import com.marcelo.pesquisando.entities.enums.EntrevistadoEscolaridade;
import com.marcelo.pesquisando.entities.enums.EntrevistadoFaixaIdade;
import com.marcelo.pesquisando.entities.enums.EntrevistadoGenero;
import com.marcelo.pesquisando.entities.enums.EntrevistadoReligiao;
import com.marcelo.pesquisando.repositories.GerenteRepository;
import com.marcelo.pesquisando.repositories.PesquisaRepository;
import com.marcelo.pesquisando.repositories.UserRepository;

@Service
public class PesquisaService {
	
	@Autowired
	private PesquisaRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private GerenteRepository repositoryGerente;
	
	@Autowired
	private ApuracaoService apuracaoService;
	
	public List<Pesquisa> findAll(){
		
		return repository.findByOrderByIdAscCodigoAsc();
	}
	
	public List<Pesquisa> findAllByCidade(String id){
		
		return repository.findAllByIdCidade(id);
	}
	public List<String> findAllBairrosByCidade(String id){
		
		return repository.agruparPorCidadeBairro(id);
	}
	
	public List<String> findAllEspontaneaByCidade(String id){
		
		return repository.agruparPorCidadeEspontanea(id);
	}
	
	public Pesquisa findById(Long id) {
		Optional<Pesquisa> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Pesquisa insert(Pesquisa obj) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		Usuario usuario = usuarioService.findByNome(user.getUsername());
		
		obj.setUserEmail(usuario.getEmail());
		
		System.out.println(obj);
		
		return repository.save(obj);
	}
	
	public void delete(Long obj) {
		repository.deleteById(obj);
	}
	
	public List<Pesquisa> upDate(Long id, Pesquisa obj) {
		
		Optional<Pesquisa> cod = repository.findById(id);
		
		List<Pesquisa> lista = repository.findByCodigo(cod.get().getCodigo());
		
		
		List<Pesquisa> entitys = new  ArrayList<>();
		
		 for(Pesquisa pesquisa : lista){
			 Pesquisa entity = repository.getOne(pesquisa.getId());
			 updateDataBairro(entity,obj);
				repository.save(entity);
				entitys.add(entity);
	        }
		 return entitys;
		
	}

	private void updateDataBairro(Pesquisa entity, Pesquisa obj) {
		
		entity.setEntrevistadoBairro(obj.getEntrevistadoBairro());
		//entity.setRespostaDissertiva(obj.getRespostaDissertiva());
			
	}
	
	
	public void updateDataBairroAll(String newBairro, String oldBairro, String idCidade) {
		
		System.out.println("<<EDIT BAIRRO>>>");
		System.out.println(idCidade);
			
		
		repository.updateAllBairro(idCidade, newBairro, oldBairro);
			
	}
	
	public void updateDataEspontaneaAll(String newEspontanea, String oldEspontanea, String idCidade) {
		
		System.out.println("<<EDIT ESPONTANEA>>>");
		System.out.println(idCidade);
			
		
		repository.updateAllEspontanea(idCidade, newEspontanea, oldEspontanea);
			
	}
	
  

	
	public Pesquisa upDateDissertativa(Long id, Pesquisa obj) {
		
		Pesquisa entity = repository.getOne(id);
		updateDataDissertativa(entity,obj);
		
		return repository.save(entity);
		
	}

	private void updateDataDissertativa(Pesquisa entity, Pesquisa obj) {
		
		entity.setRespostaDissertiva(obj.getRespostaDissertiva());
			
	}
	
	
	//COUNT POR PESQUISA
	
	public long buscaPesquisa(String pergunta){
		
		return repository.resumo(pergunta);
	}
	

	public long resumoApuration(String pergunta,String genero){
		
		return repository.resumoApuration(pergunta,genero);
	}
	
	
	public long resumoApurationAppPergunta(String pergunta){
		
		return repository.resumoApurationPergunta(pergunta);
	}
	
	
	
	
	public List<Apuracao> resumoGroupByPergunta(){
		
		List<Apuracao> listaApuracao = new ArrayList<>();
		List<String> lista = repository.resumoGrouByPergunta();
		
		 for(String item : lista){
	            
			 String novaLista[] = item.split(",");
	         			 
			 //Apuracao p = new Apuracao(novaLista[0], novaLista[1],Integer.parseInt(novaLista[2]));
			 
			 //apuracaoService.insert(p);
			 
			 //listaApuracao.add(p);
		        
	        }
	 
		
		
		return listaApuracao;
	}
	
	
	public List<LatLongPesquisa> latLong(String idCidade){
	
		List<LatLongPesquisa> latLongList = new ArrayList<>(); 
			
		List<String> lista = repository.latLong(idCidade);
		
		
		for (String p : lista) {
			
			System.out.println(p);

			
			String[] textoSeparado = p.split(",");
			System.out.println(Arrays.toString(textoSeparado));
			
			LatLongPesquisa latLong = new LatLongPesquisa(textoSeparado[0],textoSeparado[1],textoSeparado[2], textoSeparado[3],textoSeparado[4]);
			latLongList.add(latLong);
			
		}
		
		
		return latLongList;
	}

	
	public List<Integer> resumoApurationAppPerguntaPorResposta(Pergunta obj) {
		
		List<Integer> totalPorResposta = new ArrayList<>();

		obj.getRespostasWeb().forEach(resp->totalPorResposta.add(repository.resumoApurationPorRespostaDaPergunta(obj.getQuestion(), resp)));
	
		
		return totalPorResposta;
	}
	
	public Integer resumoApurationAppTotalPorPergunta(Pergunta obj) {
		
		Integer total = repository.resumoApurationPorRespostaDaPergunta(obj.getQuestion());
		
		return total;
	}
	
	public Integer totalPorPerguntaAndResposta(String pergunta, String resposta) {
		
		Integer total = repository.resumoApurationPorRespostaDaPergunta(pergunta, resposta);
		
		return total;
	}
	

	public List<Integer> resumoApurationAppPerguntaPorRespostaTipo(Pergunta obj, String tipo, String resposta) {
		
		List<String> enumsLista = new ArrayList<>();
		List<Integer> totalPorRespostaTipo = new ArrayList<Integer>();
		
		switch (tipo) {
		case "genero":
			System.out.println("EntrevistadoGenero");			
			List<EntrevistadoGenero> listaGenero = Arrays.asList(EntrevistadoGenero.values());
			
	        for (int i = 0; i < listaGenero.size(); i++) {
	        	enumsLista.add(listaGenero.get(i).toString());
	        }
	        
	        enumsLista.forEach(resp->totalPorRespostaTipo.add(repository.resumoApurationPorRespostaDaPerguntaGenero(obj.getQuestion(), resposta, resp)));
	        
			
			break;
			
		case "idade":
			System.out.println("EntrevistadoFaixaIdade");
			
			List<EntrevistadoFaixaIdade> listaIdade = Arrays.asList(EntrevistadoFaixaIdade.values());
	        for (int i = 0; i < listaIdade.size(); i++) {
	        	enumsLista.add(listaIdade.get(i).toString());

	        }
	        enumsLista.forEach(resp->totalPorRespostaTipo.add(repository.resumoApurationPorRespostaDaPerguntaIdade(obj.getQuestion(), resposta, resp)));
			
			break;
		case "religiao":
			System.out.println("EntrevistadoReligiao");
			
			List<EntrevistadoReligiao> listaReligiao = Arrays.asList(EntrevistadoReligiao.values());
	        for (int i = 0; i < listaReligiao.size(); i++) {
	        	enumsLista.add(listaReligiao.get(i).toString());
	        }
	        
	        enumsLista.forEach(resp->totalPorRespostaTipo.add(repository.resumoApurationPorRespostaDaPerguntaReligiao(obj.getQuestion(), resposta, resp)));
			
	        break;
			
		case "escolaridade":
			System.out.println("EntrevistadoEscolaridade");
			
			List<EntrevistadoEscolaridade> listaEscola = Arrays.asList(EntrevistadoEscolaridade.values());
	        for (int i = 0; i < listaEscola.size(); i++) {
	        	enumsLista.add(listaEscola.get(i).toString());

	        }
	        enumsLista.forEach(resp->totalPorRespostaTipo.add(repository.resumoApurationPorRespostaDaPerguntaEscolaridade(obj.getQuestion(), resposta, resp)));
			
			break;

		default:
			break;
		}
		
		
		return totalPorRespostaTipo;
	}

	public void upDateRespostaDissertativa(String respostaDissertiva,String entrevistadoBairro,long id) {
		
		System.out.println("<<service pesquisa>>");
		System.out.println(id);
		System.out.println(respostaDissertiva);
		
		repository.updateRespostaDissertativa(id,respostaDissertiva,entrevistadoBairro);
		
	}

	public List<String> listaRespostasDissertativas(Pergunta obj) {
		
		List<String> respostasDissertativas = repository.agruparPorDissertativa(obj.getQuestion());
		
		return respostasDissertativas;
	}

	public List<Integer> totalListaRespostasDissertativas(Pergunta obj, List<String> respostasDissertativas) {

		List<Integer> totalPorDissertativa = new ArrayList<>();

		respostasDissertativas.forEach(resp->totalPorDissertativa.add(repository.resumoApurationPorDissertativaDaPergunta(obj.getQuestion(), resp)));
	
		
		return totalPorDissertativa;
		
	}
	
	
	public List<String> listaRespostasPorBairro(Pergunta obj) {
		
		List<String> respostasBairro = repository.agruparPorBairro(obj.getQuestion());
		
		return respostasBairro;
	}

	public List<Integer> totalListaRespostasPorBairro(Pergunta obj, List<String> respostasBairro) {

		List<Integer> totalPorBairro = new ArrayList<>();

		respostasBairro.forEach(resp->totalPorBairro.add(repository.resumoApurationPorBairroDaPergunta(obj.getQuestion(), resp)));
	
		
		return totalPorBairro;
		
	}
	
	public List<Integer> totalPorPerguntaAndBairroAndResposta(Pergunta obj, String bairro) {
		
		List<Integer> totalRespostaBairro =  new ArrayList<>();
		
		for (String resposta : obj.getRespostasWeb()) {
			
			totalRespostaBairro.add(repository.resumoApurationPorRespostaDaPerguntaBairro(obj.getQuestion(), resposta, bairro));
		}
		
		return totalRespostaBairro;
		
	}
	

	public List<Integer> totalPorPerguntaAndTipoAndResposta(Pergunta obj, String tipo, String tipoResposta) {
		
		List<Integer> totalRespostaTipo =  new ArrayList<>();
				
		switch (tipo) {
		case "genero":
			System.out.println("EntrevistadoGenero");
								
			for (String resposta : obj.getRespostasWeb()) {
				
				totalRespostaTipo.add(repository.resumoApurationPorRespostaDaPerguntaGenero(obj.getQuestion(), resposta, tipoResposta.toUpperCase()));
			}	
			break;
			
		case "idade":
			System.out.println("EntrevistadoFaixaIdade");
						
			for (String resposta : obj.getRespostasWeb()) {
				
				totalRespostaTipo.add(repository.resumoApurationPorRespostaDaPerguntaIdade(obj.getQuestion(), resposta, tipoResposta.toUpperCase()));
			}
			
			break;
		case "religiao":
			System.out.println("EntrevistadoReligiao");
			
			
			for (String resposta : obj.getRespostasWeb()) {
				
				totalRespostaTipo.add(repository.resumoApurationPorRespostaDaPerguntaReligiao(obj.getQuestion(), resposta, tipoResposta.toUpperCase()));
			}
			break;
		case "escolaridade":
			System.out.println("EntrevistadoEscolaridade");
			
			
			for (String resposta : obj.getRespostasWeb()) {
				
				totalRespostaTipo.add(repository.resumoApurationPorRespostaDaPerguntaEscolaridade(obj.getQuestion(), resposta, tipoResposta.toUpperCase()));
			}
			
			break;
			
		default:
			break;
		}
		
		
		return totalRespostaTipo;
	}
	
	public Integer totalPorPerguntaAndBairro(Pergunta obj, String bairro) {
		
		Integer totalRespostaBairro = repository.resumoApurationPorPerguntaAndBairro(obj.getQuestion(), bairro);
		
		return totalRespostaBairro;
	}


	
	public Integer totalPorPerguntaAndTipo(Pergunta obj, String tipo, String tipoResposta) {
		
		Integer totalRespostaTipo = 0;
				
		switch (tipo) {
		case "genero":
			System.out.println("EntrevistadoGenero");
											
				totalRespostaTipo = repository.resumoApurationPorPerguntaAndTipoGenero(obj.getQuestion(), tipoResposta.toUpperCase());
				
			break;
			
		case "idade":
			System.out.println("EntrevistadoFaixaIdade");
						
							
			totalRespostaTipo = repository.resumoApurationPorPerguntaAndTipoFaixaIdade(obj.getQuestion(), tipoResposta.toUpperCase());
			
			
			break;
		case "religiao":
			System.out.println("EntrevistadoReligiao");
			
			totalRespostaTipo = repository.resumoApurationPorPerguntaAndTipoReligiao(obj.getQuestion(), tipoResposta.toUpperCase());			
			
			break;
		case "escolaridade":
			System.out.println("EntrevistadoEscolaridade");
		
			totalRespostaTipo = repository.resumoApurationPorPerguntaAndTipoEscolaridade(obj.getQuestion(), tipoResposta.toUpperCase());
							
			break;
			
		default:
			break;
		}
		return totalRespostaTipo;
	
	}

	


	
	
	
	
	

}
