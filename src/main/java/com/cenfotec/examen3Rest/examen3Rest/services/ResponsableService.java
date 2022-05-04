package com.cenfotec.examen3Rest.examen3Rest.services;

import com.cenfotec.examen3Rest.examen3Rest.domain.Responsable;
import com.cenfotec.examen3Rest.examen3Rest.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface ResponsableService {

    public List<Responsable> getAll();
    public Optional<Responsable> findById(long id);
    public Optional<Responsable> save(Responsable contact);
    public Optional<Responsable> update(Responsable contact);
    public Optional<Responsable> asignarUsuario(Long idEncargado, Long idUsuario);
    public boolean delete(Long id);

}
