package com.marcelo.pesquisando.resources;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.entities.Apuracao;
import com.marcelo.pesquisando.entities.LatLongPesquisa;
import com.marcelo.pesquisando.services.NotificationService;
import com.marcelo.pesquisando.services.PesquisaService;


@Controller
@RestController
@RequestMapping(value = "/pesquisas")
public class PesquisaResource {
	
	
	@Autowired
	private PesquisaService service;
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping
	public ResponseEntity<List<Pesquisa>> findAll(){
		
		List<Pesquisa> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/cidade/{id}")
	public ResponseEntity<List<Pesquisa>> findAllByIdCidade(@PathVariable String id){
		
		List<Pesquisa> list = service.findAllByCidade(id);
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/bairros/cidade/{id}")
	public ResponseEntity<List<String>> findAllBairrosByIdCidade(@PathVariable String id){
		
		List<String> list = service.findAllBairrosByCidade(id);
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/latlong/{id}")
	public ResponseEntity<List<LatLongPesquisa>> findAllLatLongByIdCidade(@PathVariable String id){
		
		List<LatLongPesquisa> list = service.latLong(id);
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/espontanea/cidade/{id}")
	public ResponseEntity<List<String>> findAllEspontaneaByIdCidade(@PathVariable String id){
		
		List<String> list = service.findAllEspontaneaByCidade(id);
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pesquisa> findById(@PathVariable Long id){
		Pesquisa obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{idCidade}/{idPesquisa}")
	public ResponseEntity<Pesquisa> findByIdCidadeAndPesquisa(@PathVariable String idCidade,@PathVariable Long idPesquisa ){
		
		Pesquisa obj = service.findById(idPesquisa);
		System.out.println(obj.getIdCidade());
		System.out.println(idCidade);
		
		
		if(obj.getIdCidade().equals(idCidade)) {
			System.out.println("<<1>>");			
			return ResponseEntity.ok().body(obj);
			
		}else {
			System.out.println("<<2>>");
			return ResponseEntity.badRequest().body(obj);
		}
		
		
	}
	
	/*
	@PostMapping
	public ResponseEntity<Pesquisa> insert(@RequestBody Pesquisa obj){
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(obj);
	}
	*/
	
	
	@PostMapping
	public ResponseEntity<List<Pesquisa>> insert(@RequestBody List<Pesquisa> obj){

		
		System.out.println(obj);
		
		List<Pesquisa> pesquisas = obj;
		
		for (Pesquisa pesquisa : pesquisas) {
			service.insert(pesquisa);
		}
		
		long totalEntrevistados = service.totalEntrevistadosPorCidade(obj.get(0).getIdCidade());
		
		double restoCliente = totalEntrevistados % 100;
		double restoGerente = totalEntrevistados % 10;
		
		if(restoCliente == 0) {
			notificationService.sendNotificationApuracaoCliente(obj.get(0));
		}
		
		if(restoGerente == 0) {
			notificationService.sendNotificationApuracaoGerente(obj.get(0));
		}
		
		
				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pesquisas.get(0).getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(pesquisas);
		//return ResponseEntity.created(uri).body("");
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/bairro/{id}")
	public ResponseEntity<List<Pesquisa>> updateBairro(@PathVariable Long id, @RequestBody Pesquisa obj){
		
		List<Pesquisa> objs = service.upDate(id, obj);
		
		return ResponseEntity.ok().body(objs);
	}
	
	@PutMapping(value = "/bairro/all/{id}/{newBairro}/{oldBairro}")
	public ResponseEntity<String> updateAllBairro(@PathVariable String id, @PathVariable String newBairro, @PathVariable String oldBairro){
		
		System.out.println(newBairro);
		System.out.println(oldBairro);
				
		service.updateDataBairroAll(newBairro, oldBairro, id);	
				
		return ResponseEntity.ok().body("Bairros Alterados");
	}
	
	@PutMapping(value = "/espontanea/all/{id}/{newEspontanea}/{oldEspontanea}")
	public ResponseEntity<String> updateAllEspontanea(@PathVariable String id, @PathVariable String newEspontanea, @PathVariable String oldEspontanea){
		
		System.out.println(newEspontanea);
		System.out.println(oldEspontanea);
				
		service.updateDataEspontaneaAll(newEspontanea, oldEspontanea, id);	
				
		return ResponseEntity.ok().body("Respostas Espontâneas Alteradas");
	}
	
	@PutMapping(value = "/dissertativa/{id}")
	public ResponseEntity<Pesquisa> updateDissertativa(@PathVariable Long id, @RequestBody Pesquisa obj){
		
		obj = service.upDateDissertativa(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/resumo")
	public ResponseEntity<Long> resumoPesquisa(){
		
		long qtd = service.buscaPesquisa("");
		
		 return ResponseEntity.ok().body(qtd);
	}
	
	@GetMapping(value = "/apuration")
	public ResponseEntity<Long> resumoApuracion(){
		
		String pergunta = "O que você acha da limpeza as calçadas?";
		String genero = "HOMEM";
		
		long qtd = service.resumoApuration(pergunta, genero);
		
		 return ResponseEntity.ok().body(qtd);
	}
	
	@GetMapping(value = "/apuration2")
	public ResponseEntity<String> groupByPergunta(){
		
		List<Apuracao> list = service.resumoGroupByPergunta(); 
		
		 return ResponseEntity.ok().body(list.toString());
		
	}
	
	
	
	
	
	//Exportar para CSV
	@GetMapping(value = "/export")
	public void exportToCsv(HttpServletResponse response) throws IOException {
		
		response.setContentType("text/csv");
	
		
		// data/hora atual
		LocalDateTime agora = LocalDateTime.now();

		// formatar a data
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("ddMMuuuuhhmm");
		String dataFormatada = formatterData.format(agora);

		System.out.println(dataFormatada);
		
		String nomeArquivo = "pesquisa_";
		
		String headerKey = "Content-Disposition";
		String headervalue = "attachement; filename="+nomeArquivo+dataFormatada+".csv";
		
		response.setHeader(headerKey, headervalue);
		
		List<Pesquisa> listPesquisa = service.findAll();
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		
		String[] csvHeader = {"id","Código","Cidade","Pergunta","Resposta","OBS","Nome","Bairro","Rua","Numero","Genero","FaixaIdade","Religiao", "Escolaridade","usuario"};
		
		String[] nameMapping = {"id","codigo","cidade","Pergunta","Resposta","respostaDissertiva","entrevistadoNome","entrevistadoBairro","entrevistadoRua","entrevistadoNumero","entrevistadoGenero","entrevistadoFaixaIdade","entrevistadoReligiao","entrevistadoEscolaridade","usuarioApp"};
		
		csvWriter.writeHeader(csvHeader);
		
		for (Pesquisa pesquisa : listPesquisa) {
			csvWriter.write(pesquisa, nameMapping);
		}
		
		csvWriter.close();
		
	}
	
	//Exportar para EXCEL Desabilitado
	@GetMapping(value = "/export/excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		
		List<Pesquisa> listPesquisa = service.findAll();
		Workbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
			
		
		
		response.setContentType("text/csv");
		
		String headerKey = "Content-Disposition";
		String headervalue = "attachement; filename=pesquisas.csv";
		
		response.setHeader(headerKey, headervalue);
		
		
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		
		String[] csvHeader = {"id","Código","Cidade","Escolaridade","FaixaIdade", "Genero","Nome","Religiao","Pergunta","Resposta","OBS","Usuario"};
		
		String[] nameMapping = {"id","codigo","cidade","entrevistadoEscolaridade","entrevistadoFaixaIdade","entrevistadoGenero","entrevistadoNome","entrevistadoReligiao","Pergunta","Resposta","respostaDissertiva","usuarioApp"};
		
		csvWriter.writeHeader(csvHeader);
		
		for (Pesquisa pesquisa : listPesquisa) {
			csvWriter.write(pesquisa, nameMapping);
		}
		
		csvWriter.close();
		
	}
	

	
}
