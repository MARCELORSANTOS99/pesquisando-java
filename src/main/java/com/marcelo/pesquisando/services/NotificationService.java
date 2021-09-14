package com.marcelo.pesquisando.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.pesquisando.entities.Notification;
import com.marcelo.pesquisando.entities.RootNotification;
import com.marcelo.pesquisando.notification.Notifications;

@Service
public class NotificationService {
	

	@Autowired
	private Notifications notifications;
	
	
	
	public void sendNotification() {
		
		List<String> tokens = new ArrayList<>();
		String token = "eIG6KlsGS9SFjE9lnBQ0aS:APA91bHdBKR5JRP1HNgkcRf-HGYQ79ccxXYjeNA4zOlSst9n6uhkbrOl3Hmhny06SxoP-SKTSM6imJbjWd3q6Uxy6R_1iMhiQLM4f5H9IzRCShN6AEBtQ6G1tG_nAUWtt8gNs8ubClbC";
		String token2 = "dowSgu8xTs-7czIWCF5kEy:APA91bGPoq6wrzI40ELFbqyoU_6SbhEVA1BeannaS85yYOP4pklkte7VhPfFJegPykCXHycFoRrFOAAw1pWnWBL9sXbjJRuBiIZzK5g1hw6CSUPdqjFQwSXLDWs3xomedwXkwQb1Q11f";
		String token3 = "eePUI1BJTjav7BRAiVdkfI:APA91bFwzab0Yw3Kl9IqpU6pZnfcy6KF3dhBz987OZgAo1g8jRjiATcTTMdgcpGUnBPaC2r4PXGthIg3iLlIoBspS2_XmMalwZJsnPWJzL9tAcPZTBDTU2Jcr52kjSWK3qyZnHdgiPAx";
		tokens.add(token);
		tokens.add(token2);
		tokens.add(token3);
		
		Notification notification = new Notification("Apuração on line \uD83D\uDCCA", "Pergunta 1 \nResposta1 - 25%\nResposta2 - 35%");
		RootNotification rootNotification = new RootNotification(notification,tokens);
		String authorization = "key=AAAAqnlaSjg:APA91bFcvLBioA5-wlxLGMQJBgQWepAJTc3BHcyK2L-EvRwr2rMLzga-2zxGsN06bc-BC9ZiiM-IPyygx5Y5Eblo1vTWDsm7re1yAFQttA_GRqpw1BrYK-lCF42pZwxwYInW1NhPvZL_";
		
		notifications.sendNotification(rootNotification,authorization);
		System.out.println(rootNotification.toString());
		
	}
		

}
