package com.marcelo.pesquisando.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.marcelo.pesquisando.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	@Query(value = "SELECT u FROM Usuario u where u.uid = ?1")
	Optional<Usuario> findByUid(String uid);

}
