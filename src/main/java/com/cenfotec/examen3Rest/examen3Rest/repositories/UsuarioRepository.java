package com.cenfotec.examen3Rest.examen3Rest.repositories;

import com.cenfotec.examen3Rest.examen3Rest.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { }
