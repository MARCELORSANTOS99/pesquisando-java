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
	         			 
			 //Apuracao p = new Apuracao(novaLista[0], novaLista[1],Integer.parseInt(novaLista[2]));
			 
			 //apuracaoService.insert(p);
			 
			 //listaApuracao.add(p);
		        
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

	public void upDateRespostaDissertativa(String respostaDissertiva,long id) {
		
		System.out.println("<<service pesquisa>>");
		System.out.println(id);
		System.out.println(respostaDissertiva);
		
		repository.updateRespostaDissertativa(id,respostaDissertiva);
		
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
