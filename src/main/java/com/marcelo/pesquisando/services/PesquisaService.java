package com.marcelo.pesquisando.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Apuracao;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.entities.Resposta;
import com.marcelo.pesquisando.entities.enums.EntrevistadoEscolaridade;
import com.marcelo.pesquisando.entities.enums.EntrevistadoFaixaIdade;
import com.marcelo.pesquisando.entities.enums.EntrevistadoGenero;
import com.marcelo.pesquisando.entities.enums.EntrevistadoReligiao;
import com.marcelo.pesquisando.repositories.PesquisaRepository;

@Service
public class PesquisaService {
	
	@Autowired
	private PesquisaRepository repository;
	
	@Autowired
	private ApuracaoService apuracaoService;
	
	public List<Pesquisa> findAll(){
		
		return repository.findByOrderByIdAscCodigoAsc();
	}
	
	public Pesquisa findById(Long id) {
		Optional<Pesquisa> obj =  repository.findById(id);
		return obj.get();
	}
	
	
	public Pesquisa insert(Pesquisa obj) {
				
		return repository.save(obj);
		
	}
	
	public void delete(Long obj) {
		repository.deleteById(obj);
	}
	
	public Pesquisa upDate(Long id, Pesquisa obj) {
		
		Pesquisa entity = repository.getOne(id);
		updateData(entity,obj);
		
		return repository.save(entity);
	}

	private void updateData(Pesquisa entity, Pesquisa obj) {
		
		entity.setCidade(obj.getCidade());
			
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
	         			 
			 Apuracao p = new Apuracao(novaLista[0], novaLista[1],Integer.parseInt(novaLista[2]));
			 
			 //apuracaoService.insert(p);
			 
			 listaApuracao.add(p);
		        
	        }
	 
		
		
		return listaApuracao;
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




	
	
	
	
	

}
