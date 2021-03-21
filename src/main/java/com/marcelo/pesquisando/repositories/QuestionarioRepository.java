package com.marcelo.pesquisando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.pesquisando.entities.Questionario;

public interface QuestionarioRepository extends JpaRepository<Questionario, Long> {

}
