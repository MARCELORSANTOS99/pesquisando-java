package com.marcelo.pesquisando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.pesquisando.entities.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
