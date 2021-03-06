package com.marcelo.pesquisando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.services.CidadeService;
import com.marcelo.pesquisando.services.PerguntaService;

@Controller
public class HomeController {
	
	@Autowired
	private PerguntaService service;
	
	@Autowired
	private CidadeService cityService;
	
	@GetMapping("home")
	public String home(Model model) {

		List<Pergunta> perguntas = service.findAll();
		List<Cidade> cidades = cityService.findAll();
		
		System.out.println("<<<lista pergutas>>>>");
		System.out.println(perguntas);
		
		String version = "1.0.1";
    			
		model.addAttribute("perguntas", perguntas);
		model.addAttribute("cidades", cidades);
		model.addAttribute("version", version);
		
		
		return "home";
	}	
	 
}
