package com.marcelo.pesquisando.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.services.PerguntaService;

@Controller
public class HomeController {
	
	@Autowired
	private PerguntaService service;
	
	@GetMapping("home")
	public String home(Model model) {

		List<Pergunta> perguntas = service.findAll();
		
		int tamanho = perguntas.size();
		
		for (int i = 0; i < tamanho; i++) {
			
		}
		
	    			
		model.addAttribute("perguntas", perguntas);
		
		
		return "home";
	}	
	 
}
