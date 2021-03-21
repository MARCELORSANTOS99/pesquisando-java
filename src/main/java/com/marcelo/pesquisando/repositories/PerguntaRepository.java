package com.marcelo.pesquisando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.pesquisando.entities.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

}
