package com.cenfotec.examen3Rest.examen3Rest.services;

import com.cenfotec.examen3Rest.examen3Rest.domain.Responsable;
import com.cenfotec.examen3Rest.examen3Rest.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public List<Usuario> getAll();
    public Optional<Usuario> findById(long id);
    public Optional<Usuario> save(Usuario usuario);
    public Optional<Usuario> update(Usuario usuario);
    public Optional<Usuario> asignarResponsable (Long idEncargado, Long idUsuario);
    public boolean delete(Long id);

}