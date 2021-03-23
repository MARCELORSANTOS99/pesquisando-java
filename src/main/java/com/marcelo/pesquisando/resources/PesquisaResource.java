package com.marcelo.pesquisando.resources;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

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
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.services.PesquisaService;

@RestController
@RequestMapping(value = "/pesquisas")
public class PesquisaResource {
	
	
	@Autowired
	private PesquisaService service;
	
	@GetMapping
	public ResponseEntity<List<Pesquisa>> findAll(){
		
		List<Pesquisa> list = service.findAll();
		
		 return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pesquisa> findById(@PathVariable Long id){
		Pesquisa obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Pesquisa> insert(@RequestBody Pesquisa obj){
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
	public ResponseEntity<Pesquisa> update(@PathVariable Long id, @RequestBody Pesquisa obj){
		obj = service.upDate(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/resumo")
	public ResponseEntity<Long> resumoPesquisa(){
		
		long qtd = service.buscaPesquisa("Bolsonaro");
		
		 return ResponseEntity.ok().body(qtd);
	}
	
	//Exportar para CSV
	@GetMapping(value = "/export")
	public void exportToCsv(HttpServletResponse response) throws IOException {
		
		response.setContentType("text/csv");
		String fileName = "pesquisas.csv";
		
		String headerKey = "Content-Disposition";
		String headervalue = "attachement; filename" + fileName;
		
		response.setHeader(headerKey, headervalue);
		
		List<Pesquisa> listPesquisa = service.findAll();
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		
		//String[] csvHeader = {"id","Cidade"};
		//String[] csvHeader = {"id","Cidade","Escolaridade"};
		String[] csvHeader = {"id","Cidade","Escolaridade","FaixaIdade", "Genero","Nome","Religiao","Pergunta","Resposta"};
		
		//String[] nameMapping = {"id","cidade"};
		//String[] nameMapping = {"id","cidade","entrevistadoEscolaridade"};
		String[] nameMapping = {"id","cidade","entrevistadoEscolaridade","entrevistadoFaixaIdade","entrevistadoGenero","entrevistadoNome","entrevistadoReligiao","Pergunta","Resposta"};
		
		csvWriter.writeHeader(csvHeader);
		
		for (Pesquisa pesquisa : listPesquisa) {
			csvWriter.write(pesquisa, nameMapping);
		}
		
		csvWriter.close();
		
	}
	

}
