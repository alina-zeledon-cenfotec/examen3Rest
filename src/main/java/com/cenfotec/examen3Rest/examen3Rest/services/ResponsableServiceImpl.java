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
public class ResponsableServiceImpl implements ResponsableService{

        @Autowired
        ResponsableRepository responsableRepo;

        @Autowired
        UsuarioRepository usuarioRepo;

        @Override
        public List<Responsable> getAll() {
            return responsableRepo.findAll();
        }

        @Override
        public Optional<Responsable> findById(long id) {
            return responsableRepo.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
        }

        @Override
        public  Optional<Responsable> save(Responsable responsable) {
            return Optional.of(responsableRepo.save(responsable));
        }

        @Override
        public  Optional<Responsable> update(Responsable responsable) {
            Optional<Responsable> record = responsableRepo.findById(responsable.getId());
            if (record.isPresent()) {
                Responsable data = record.get();
                data.setNombre(responsable.getNombre());
                data.setCedula(responsable.getCedula());
                data.setDireccion(responsable.getDireccion());
                data.setTelefonoPrimario(responsable.getTelefonoPrimario());
                data.setTelefonoSecundario(responsable.getTelefonoSecundario());
                return Optional.of(responsableRepo.save(data));
            }
            return Optional.empty();
        }

    @Override
    public Optional<Responsable> asignarUsuario(Long idEncargado, Long idUsuario) {

        Optional<Usuario> recordUsuario = usuarioRepo.findById(idEncargado);
        Optional<Responsable> recordReponsable = responsableRepo.findById(idUsuario);

        if(recordReponsable.isPresent() && recordUsuario.isPresent()){

            Responsable responsable = recordReponsable.get();
            responsable.setUsuario(recordUsuario.get());

            return Optional.of(responsableRepo.save(responsable));
        }
        return Optional.empty();
    }


    @Override
        public boolean delete(Long id) {
            Optional<Responsable> result = responsableRepo.findById(id);
            if (result.isPresent()){
                responsableRepo.deleteById(id);
                return true;
            }
            return false;
        }
    }
