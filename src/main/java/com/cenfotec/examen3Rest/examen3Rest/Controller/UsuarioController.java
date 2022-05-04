package com.cenfotec.examen3Rest.examen3Rest.Controller;

import com.cenfotec.examen3Rest.examen3Rest.domain.Responsable;
import com.cenfotec.examen3Rest.examen3Rest.domain.Usuario;
import com.cenfotec.examen3Rest.examen3Rest.services.ResponsableService;
import com.cenfotec.examen3Rest.examen3Rest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/usuario"})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ResponsableService responsableService;

    @GetMapping
    public List getAll(){
        return usuarioService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Usuario> findById(@PathVariable long id){
        Optional<Usuario> result = usuarioService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.save(usuario).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") long id,
                                              @RequestBody Usuario usuario){
        usuario.setId(id);
        Optional<Usuario> result = usuarioService.update(usuario);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value="/{idUsuario}/responsable/{idResponsable}")
    public ResponseEntity<Usuario> asignEncargado(@PathVariable("idUsuario") long idUsuario,
                                                     @PathVariable("idResponsable") long idResponsable){

        Optional<Usuario> result = usuarioService.asignarResponsable(idUsuario, idResponsable);

        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (usuarioService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
