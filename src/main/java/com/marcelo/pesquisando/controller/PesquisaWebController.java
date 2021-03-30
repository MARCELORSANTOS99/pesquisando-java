package com.marcelo.pesquisando.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marcelo.pesquisando.dto.RequisicaoEditPesquisa;
import com.marcelo.pesquisando.dto.RequisicaoNovaPesquisa;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.entities.Resposta;
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

	@GetMapping("formulario/edit/{id}")
	public String formularioEdit(@PathVariable(name = "id") long id, Model model) {

		Pergunta pergunta = perguntaService.findById(id);
		model.addAttribute("pergunta", pergunta);

		model.addAttribute("respostas", pergunta.getRespostasWeb());

		return "pesquisa/formularioEdit";
	}

	@GetMapping("resumo")
	public String resumo(Model model) {

		List<Pesquisa> pesquisas = pesquisaService.findAll();

		model.addAttribute("pesquisas", pesquisas);

		return "pesquisa/resumo";
	}

	@PostMapping("novo")
	public String novo(RequisicaoNovaPesquisa requisicao) {

		System.out.println("MÉTODO INSERT");
		Pergunta pergunta = requisicao.toPesquisa();

			
			perguntaService.insert(pergunta);
		
				

		return "redirect:/home";

	}

	@RequestMapping("/delete/{id}")
	public String deletePergunta(@PathVariable(name = "id") long id) {

		respostaService.delete(id);
		perguntaService.delete(id);

		return "redirect:/home";
	}

}
