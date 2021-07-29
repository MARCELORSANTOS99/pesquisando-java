package com.marcelo.pesquisando.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcelo.pesquisando.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String EmailUser);
	
	Optional<Usuario> findByNome(String nomeUser);
	

}
