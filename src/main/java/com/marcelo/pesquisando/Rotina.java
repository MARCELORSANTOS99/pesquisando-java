package com.marcelo.pesquisando;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.marcelo.pesquisando.entities.Cidade;
import com.marcelo.pesquisando.services.CidadeService;

@Component
@EnableScheduling
public class Rotina {
	
	@Autowired
	private CidadeService service;
	
    private final long MINUT = 1000 * 60;
	
    @Scheduled(fixedDelay = MINUT)
    public void scheduleFutureTask() {
    	
		List<Cidade> list = service.findAll();
		System.out.println("schedule ok!");
		System.out.println(list);
	
    }
}
