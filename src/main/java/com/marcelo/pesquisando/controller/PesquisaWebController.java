package com.marcelo.pesquisando.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcelo.pesquisando.dto.RequisicaoNovaPesquisa;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.services.PerguntaService;

@Controller
@RequestMapping("pesquisa")
public class PesquisaWebController {
	
	
		@Autowired
		private PerguntaService perguntaService;

		@GetMapping("formulario")
		public String formulario() {
			return "pesquisa/formulario";
		}
		
		@GetMapping("resumo")
		public String resumo() {
			return "pesquisa/resumo";
		}
		
		@PostMapping("novo")
		public String novo(RequisicaoNovaPesquisa requisicao) {
			
			Pergunta pergunta = requisicao.toPesquisa();
			
			perguntaService.insert(pergunta);
			
			return "pesquisa/formulario";
			
		}
	
}
