package com.marcelo.pesquisando.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcelo.pesquisando.entities.Entrevistado;

public interface EntrevistadoRepository extends JpaRepository<Entrevistado, Long> {

}
