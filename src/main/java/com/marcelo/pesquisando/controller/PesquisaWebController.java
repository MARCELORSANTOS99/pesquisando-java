package com.marcelo.pesquisando.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marcelo.pesquisando.dto.RequisicaoNovaPesquisa;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.entities.Resposta;
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
		

		@GetMapping("formulario")
		public String formulario(RequisicaoNovaPesquisa requisicao) {
	
			return "pesquisa/formulario";
		}
		
		@GetMapping("resumo")
		public String resumo(Model model) {
			
			List<Pesquisa> pesquisas = pesquisaService.findAll();
				
			model.addAttribute("pesquisas", pesquisas);
			
			return "pesquisa/resumo";
		}
		
		@PostMapping("novo")
		public String novo(@Valid RequisicaoNovaPesquisa requisicao, BindingResult result) {
			
			if (result.hasErrors()) {
				return "pesquisa/formulario";
			}
			
			Pergunta pergunta = requisicao.toPesquisa();
								
			perguntaService.insert(pergunta);
			
			return "pesquisa/formulario";
			
		}
		
		@RequestMapping("/delete/{id}")
		public String deletePergunta(@PathVariable(name = "id") long id) {
							
			respostaService.delete(id);
			perguntaService.delete(id);
			
			
		    return "home";       
		}
		
	
}
