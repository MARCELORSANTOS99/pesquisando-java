package com.marcelo.pesquisando.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcelo.pesquisando.dto.RequisicaoNovaCidade;
import com.marcelo.pesquisando.dto.RequisicaoNovaPesquisa;
import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.repositories.PerguntaRepository;
import com.marcelo.pesquisando.services.CidadeService;

@Controller
@RequestMapping("cidade")
public class CidadeWebController {

	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	PerguntaRepository cidadeRepository; 

	@GetMapping("formulario")
	public String formulario(RequisicaoNovaPesquisa requisicao, Model model) {
		
		List<Cidade> cidades = cidadeService.findAll();
		model.addAttribute("cidades", cidades);
		
		model.addAttribute("cidade",cidades);

		return "cidade/formulario";
	}
	
	@PostMapping("novo")
	public String novo(RequisicaoNovaCidade requisicao) {
		
		List<Cidade> cidades = cidadeService.findAll();
		
		/*
		for (int i = 0; i < cidades.size(); i++) {	
			System.out.println("Deletando cidades antes de inserir...");
			cidadeService.delete(cidades.get(i).getId());
		}
		*/
		

		System.out.println("MÉTODO INSERT");
		Cidade cidade = requisicao.toCidade();
			
		cidadeService.insert(cidade);
		
		return "redirect:/home";

	}
	
	

	@PostMapping("/edit/{id}")
	public String formularioEdit(@PathVariable(name = "id") long id, Model model) {
		
		Cidade cidade = cidadeService.findById(id);
		
		cidadeService.insert(cidade);
		
		
				
		return "cidade/formulario";
	}

	@RequestMapping("/delete/{id}")
	public String deletePergunta(@PathVariable(name = "id") long id) {

		cidadeService.delete(id);
		
		return "redirect:/home";
	}

}
