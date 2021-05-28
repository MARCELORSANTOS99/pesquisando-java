package com.marcelo.pesquisando.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marcelo.pesquisando.dto.RequisicaoEditRespostaPesquisa;
import com.marcelo.pesquisando.dto.RequisicaoNovaPesquisa;
import com.marcelo.pesquisando.entities.Apuracao;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.repositories.PerguntaRepository;
import com.marcelo.pesquisando.services.PerguntaService;
import com.marcelo.pesquisando.services.PesquisaService;
import com.marcelo.pesquisando.services.RespostaService;

@Controller
@RequestMapping("pesquisa")
public class PesquisaWebController {

	@Autowired
	private PerguntaService perguntaService;

	@Autowired
	private PesquisaService pesquisaService;

	@Autowired
	private RespostaService respostaService;

	@Autowired
	PerguntaRepository perguntaRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovaPesquisa requisicao) {

		return "pesquisa/formulario";
	}

	/*
	@GetMapping("formulario/edit/{id}")
	public String formularioEdit(@PathVariable(name = "id") long id, Model model) {

		Pergunta pergunta = perguntaService.findById(id);
		model.addAttribute("pergunta", pergunta);

		//model.addAttribute("respostas", pergunta.getRespostasWeb());

		return "pesquisa/formularioEdit";
	}
	*/
	
	@GetMapping(value = {"/edit/{id}"})
	public String showEditContact(Model model, @PathVariable long id) {
		
		System.out.println(">>>>");
		Pergunta pergunta = null;
	   
	   	pergunta = perguntaService.findById(id);
	   	
	   	System.out.println(pergunta.getQuestion());
	  
	   	List<Pergunta> perguntas = new ArrayList<>();
	   	perguntas.add(pergunta);
	   	System.out.println(perguntas);
	  
	    model.addAttribute("perguntas", perguntas);
	    return "redirect:/hello";
	}
	
	@GetMapping(value = {"/resumo/pesquisa/edit/{id}"})
	public String showEditObservacao(Model model, @PathVariable long id) {
		
		System.out.println(">>>>");
		Pesquisa pesquisa = pesquisaService.findById(id); 
	   
	   	System.out.println(pesquisa.getRespostaDissertiva());
	  		  
	    model.addAttribute("pesquisa", pesquisa);
	    return "pesquisa/edit";
	}
	

	@GetMapping("resumo")
	public String resumo(Model model) {

		List<Pesquisa> pesquisas = pesquisaService.findAll();

		model.addAttribute("pesquisas", pesquisas);

		return "pesquisa/resumo";
	}

	@GetMapping("apuracao")
	public String apuracao(Model model) {

		List<Pesquisa> pesquisas = pesquisaService.findAll();

		long totalPerguntas = pesquisaService.resumoApuration("O que você acha da limpeza as calçadas?", "null");

		model.addAttribute("pesquisas", pesquisas);
		model.addAttribute("totalPerguntas", totalPerguntas);

		return "pesquisa/apuracao";
	}

	@GetMapping("apuracao2")
	public String apuracao2(Model model) {

		List<Apuracao> pesquisasGroups = pesquisaService.resumoGroupByPergunta();
		
		model.addAttribute("pesquisasGroup", pesquisasGroups);
				

		return "pesquisa/apuracao2";
	}

	@PostMapping("novo")
	public String novo(RequisicaoNovaPesquisa requisicao) {

		System.out.println("MÉTODO INSERT");
		Pergunta pergunta = requisicao.toPesquisa();

		perguntaService.insert(pergunta);

		return "redirect:/home";

	}
	

	@PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") long id, Pesquisa pesquisa, Model model) {

		System.out.println("MÉTODO UPDATE");
		
		System.out.println(pesquisa.getRespostaDissertiva());
		
		pesquisaService.upDateRespostaDissertativa(pesquisa.getRespostaDissertiva(),pesquisa.getEntrevistadoBairro(),id);
		

		return "redirect:/home";

	}

	@RequestMapping("/delete/{id}")
	public String deletePergunta(@PathVariable(name = "id") long id) {

		respostaService.delete(id);
		perguntaService.delete(id);

		return "redirect:/home";
	}

}
