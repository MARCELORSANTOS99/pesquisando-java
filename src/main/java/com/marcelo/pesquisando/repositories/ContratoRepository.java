package com.marcelo.pesquisando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.pesquisando.entities.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

}
