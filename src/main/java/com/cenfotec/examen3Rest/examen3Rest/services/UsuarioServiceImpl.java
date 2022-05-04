package com.cenfotec.examen3Rest.examen3Rest.services;

import com.cenfotec.examen3Rest.examen3Rest.domain.Responsable;
import com.cenfotec.examen3Rest.examen3Rest.domain.Usuario;
import com.cenfotec.examen3Rest.examen3Rest.repositories.ResponsableRepository;
import com.cenfotec.examen3Rest.examen3Rest.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepo;
    @Autowired
    ResponsableRepository responsableRepo;

    @Override
    public List<Usuario> getAll() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> findById(long id) {
        return usuarioRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    @Override
    public  Optional<Usuario> save(Usuario contact) {
        return Optional.of(usuarioRepo.save(contact));
    }

    @Override
    public  Optional<Usuario> update(Usuario usuario) {
        Optional<Usuario> record = usuarioRepo.findById(usuario.getId());
        if (record.isPresent()) {
            Usuario data = record.get();
            data.setNombre(usuario.getNombre());
            data.setPlan(usuario.getPlan());
            data.setAlergias(usuario.getAlergias());
            data.setResponsable(usuario.getResponsable());
            return Optional.of(usuarioRepo.save(data));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> asignarResponsable(Long idEncargado, Long idUsuario) {

        Optional<Usuario> recordUsuario = usuarioRepo.findById(idEncargado);
        Optional<Responsable> recordReponsable = responsableRepo.findById(idUsuario);

        if(recordReponsable.isPresent() && recordUsuario.isPresent()){

            Usuario user = recordUsuario.get();
            user.setResponsable(recordReponsable.get());
            return Optional.of(usuarioRepo.save(user));
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        Optional<Usuario> result = usuarioRepo.findById(id);
        if (result.isPresent()){
            usuarioRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
