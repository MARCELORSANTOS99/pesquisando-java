	package com.marcelo.pesquisando.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.pesquisando.entities.BairroApuracao;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.PerguntaApuracao;
import com.marcelo.pesquisando.entities.RespostaApuracao;
import com.marcelo.pesquisando.entities.TipoApuracao;
import com.marcelo.pesquisando.entities.enums.EntrevistadoGenero;
import com.marcelo.pesquisando.entities.enums.EntrevistadoEscolaridade;
import com.marcelo.pesquisando.entities.enums.EntrevistadoFaixaIdade;
import com.marcelo.pesquisando.entities.enums.EntrevistadoReligiao;
import com.marcelo.pesquisando.services.CidadeService;
import com.marcelo.pesquisando.services.PerguntaService;
import com.marcelo.pesquisando.services.PesquisaService;
import com.marcelo.pesquisando.services.RespostaService;

@RestController
@RequestMapping(value = "/perguntas")
public class PerguntaResource {
	
	
	@Autowired
	private PerguntaService service;
	
	@Autowired
	private PesquisaService pesquisaService;
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private RespostaService respService;
	

	@GetMapping
	public ResponseEntity<List<Pergunta>> findAll(){
		
		List<Pergunta> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pergunta> findById(@PathVariable Long id){
		Pergunta obj = service.findById(id);
		
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Pergunta> insert(@PathVariable Long id, @RequestBody Pergunta obj){
		
		System.out.println(obj);
		 
		obj.setCidad(cidadeService.findById(id));
				
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
	public ResponseEntity<Pergunta> update(@PathVariable Long id, @RequestBody Pergunta obj){
		
		System.out.println("<<<ENTROU NO MÉTOD EDIT>>>");
			
		//obj.getRespostas().forEach(item->respService.upDate(item.getId(),item));
		
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@GetMapping(value = "/apuracao/{id}")
	public ResponseEntity<PerguntaApuracao> findByIdApuracao(@PathVariable Long id){
		
		Pergunta obj = service.findById(id);
		
		long total = pesquisaService.resumoApurationAppPergunta(obj.getQuestion());
		List<String> respostasDissertativas  = pesquisaService.listaRespostasDissertativas(obj);
		List<Integer> totalRespostasDissertativas  = pesquisaService.totalListaRespostasDissertativas(obj,respostasDissertativas);
		
		List<String> respostasPorBairro  = pesquisaService.listaRespostasPorBairro(obj);
		List<Integer> totalRespostasPorBairro  = pesquisaService.totalListaRespostasPorBairro(obj,respostasPorBairro);
		
		
		List<Integer> totalPorResposta = pesquisaService.resumoApurationAppPerguntaPorResposta(obj);
		Integer totalPorPergunta = pesquisaService.resumoApurationAppTotalPorPergunta(obj);
		
		System.out.println(obj.getRespostasWeb());
		System.out.println(totalPorResposta);
		
		PerguntaApuracao pergutaApurada = new PerguntaApuracao(obj.getQuestion(), obj.getRespostasWeb(), totalPorResposta, totalPorPergunta,respostasDissertativas,totalRespostasDissertativas,respostasPorBairro,totalRespostasPorBairro);
				
		return ResponseEntity.ok().body(pergutaApurada);
	}
	
	@GetMapping(value = "/apuracao/{id}/{tipo}/{resposta}")
	public ResponseEntity<RespostaApuracao> findByIdApuracaoPorTipoAndResposta(@PathVariable Long id, @PathVariable String tipo, @PathVariable String resposta){
		
		Pergunta obj = service.findById(id);
		
		List<String> enumsLista = new ArrayList<>();
		
		
		definirTipo(tipo, enumsLista);
		
		//int[] a = {10,20,30,40,50};
		//int sum = IntStream.of(a).sum();
		
		
		
		List<Integer> totalPorRespostaTipo = pesquisaService.resumoApurationAppPerguntaPorRespostaTipo(obj, tipo, resposta);
		Integer totalPerguntaResposta = pesquisaService.totalPorPerguntaAndResposta(obj.getQuestion(),resposta);
		
		
		System.out.println(enumsLista);
		System.out.println(totalPorRespostaTipo);
		
		RespostaApuracao respostaApurada = new RespostaApuracao(obj.getQuestion(),enumsLista,obj.getRespostasWeb(),resposta,totalPorRespostaTipo,totalPerguntaResposta);
				
		return ResponseEntity.ok().body(respostaApurada);
	}
	
	@GetMapping(value = "/apuracao/tipo/{id}/{tipo}/{tipoResposta}")
	public ResponseEntity<TipoApuracao> findByIdApuracaoPorTipo(@PathVariable Long id, @PathVariable String tipo, @PathVariable String tipoResposta ){
		
		Pergunta obj = service.findById(id);
				
		
		Integer totalPorPergunta = pesquisaService.totalPorPerguntaAndTipo(obj,tipo, tipoResposta.toUpperCase());

		List<Integer> totalPerguntaTipoAndResposta = pesquisaService.totalPorPerguntaAndTipoAndResposta(obj,tipo, tipoResposta.toUpperCase());
				

		TipoApuracao tipoApuracao = new TipoApuracao(obj.getQuestion(),tipo,tipoResposta,obj.getRespostasWeb(),totalPerguntaTipoAndResposta, totalPorPergunta);
				
		return ResponseEntity.ok().body(tipoApuracao);
	}
	
	@GetMapping(value = "/apuracao/bairro/{id}/{bairro}")
	public ResponseEntity<BairroApuracao> findByIdApuracaoPorBairro(@PathVariable Long id, @PathVariable String bairro ){
		
		Pergunta obj = service.findById(id);
				
		
		Integer totalPorPergunta = pesquisaService.totalPorPerguntaAndBairro(obj,bairro);

		List<Integer> totalPerguntaBairroAndResposta = pesquisaService.totalPorPerguntaAndBairroAndResposta(obj,bairro);	
		
		BairroApuracao bairroApuracao = new BairroApuracao(obj.getQuestion(),bairro,obj.getRespostasWeb(),totalPerguntaBairroAndResposta, totalPorPergunta);
				
		return ResponseEntity.ok().body(bairroApuracao);
	}


	public void definirTipo(String tipo, List<String> enumsLista) {
		switch (tipo) {
		case "genero":
			System.out.println("EntrevistadoGenero");
						
			List<EntrevistadoGenero> listaGenero = Arrays.asList(EntrevistadoGenero.values());
	        for (int i = 0; i < listaGenero.size(); i++) {
	        	enumsLista.add(listaGenero.get(i).toString());
	        }		
			
			break;
		case "idade":
			System.out.println("EntrevistadoFaixaIdade");
						
			List<EntrevistadoFaixaIdade> listaIdade = Arrays.asList(EntrevistadoFaixaIdade.values());
	        for (int i = 0; i < listaIdade.size(); i++) {
	        	enumsLista.add(listaIdade.get(i).toString());
	        }
			
			break;
		case "religiao":
			System.out.println("EntrevistadoReligiao");
			
			
			List<EntrevistadoReligiao> listaReligiao = Arrays.asList(EntrevistadoReligiao.values());
	        for (int i = 0; i < listaReligiao.size(); i++) {
	        	enumsLista.add(listaReligiao.get(i).toString());
	        }
			break;
		case "escolaridade":
			System.out.println("EntrevistadoEscolaridade");
			
			
			List<EntrevistadoEscolaridade> listaEscola = Arrays.asList(EntrevistadoEscolaridade.values());
	        for (int i = 0; i < listaEscola.size(); i++) {
	        	enumsLista.add(listaEscola.get(i).toString());
	        }
			
			break;

		default:
			break;
		}
	}	
	
}
