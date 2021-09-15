package com.marcelo.pesquisando.services;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.entities.Notification;
import com.marcelo.pesquisando.entities.Pergunta;
import com.marcelo.pesquisando.entities.Pesquisa;
import com.marcelo.pesquisando.entities.RootNotification;
import com.marcelo.pesquisando.entities.Usuario;
import com.marcelo.pesquisando.notification.Notifications;

@Service
public class NotificationService {
	

	@Autowired
	private Notifications notifications;
	
	@Autowired
	private PesquisaService pesquisaService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CidadeService cidadeService;
	
	String authorization = "key=AAAAqnlaSjg:APA91bFcvLBioA5-wlxLGMQJBgQWepAJTc3BHcyK2L-EvRwr2rMLzga-2zxGsN06bc-BC9ZiiM-IPyygx5Y5Eblo1vTWDsm7re1yAFQttA_GRqpw1BrYK-lCF42pZwxwYInW1NhPvZL_";
	
	
	
	public void sendNotificationApuracaoCliente(Pesquisa obj) {
		
		List<String> tokens = new ArrayList<>();
		
		String perguntaNotificacao = perguntasToNotificacaoCliente(obj);
		String token = buscarTokenCliente(obj);
		
		
		tokens.add(token);
		
		
	
		Notification notification = new Notification("Apuração on line \uD83D\uDCCA", perguntaNotificacao);
		RootNotification rootNotification = new RootNotification(notification,tokens);
		
		
		notifications.sendNotification(rootNotification,authorization);
		System.out.println(rootNotification.toString());
		
	}



	public String perguntasToNotificacaoCliente(Pesquisa obj) {
	
		StringBuilder stringBuilder = new StringBuilder(200);

		Cidade cidade = cidadeService.findById(Long.valueOf(obj.getIdCidade()));
		List<Pergunta> perguntas = cidade.getPerguntas();
		
		
		for (int i = 0; i < perguntas.size(); i++) {
			if(perguntas.get(i).getNotificacao()) {
				stringBuilder.append(perguntas.get(i).getQuestion());
				stringBuilder.append("\n");
				List<Integer> totalPorResposta =  pesquisaService.resumoApurationAppPerguntaPorResposta(perguntas.get(i));
				Integer totalPorPergunta = pesquisaService.resumoApurationAppTotalPorPergunta(perguntas.get(i));
				
				for (int j = 0; j < perguntas.get(i).getRespostas().size(); j++) {
					stringBuilder.append(perguntas.get(i).getRespostas().get(j).getResp());
					stringBuilder.append(" - ");
					System.out.println(" TOTAL POR RESPOSTA"+totalPorResposta.get(j));
					
					
					String resultado = String.format("%.2f", (((double)totalPorResposta.get(j)/(double)totalPorPergunta)*100));

					
					stringBuilder.append(resultado);
					stringBuilder.append("%");
					stringBuilder.append("\n");		
					
				}
				
			}
			
		}
		
		return stringBuilder.toString();
		
		
	}



	public String buscarTokenCliente(Pesquisa obj) {
		long idCidade = Long.valueOf(obj.getIdCidade());
		
		Cidade cidade = cidadeService.findById(idCidade);
		System.out.println("CIDADE =>"+cidade);
		String cliente = cidade.getNomeCliente();
		System.out.println("CLIENTE =>"+cliente);
		Usuario usuario = usuarioService.findByNome(cliente);
		System.out.println("USUARIO =>"+usuario);
		String token = usuario.getTokenFirebase();
		System.out.println("TOKEN =>"+token);
		return token;
	}
		

}
