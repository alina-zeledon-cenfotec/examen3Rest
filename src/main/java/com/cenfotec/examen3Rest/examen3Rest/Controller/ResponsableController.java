package com.cenfotec.examen3Rest.examen3Rest.Controller;

import com.cenfotec.examen3Rest.examen3Rest.domain.Responsable;
import com.cenfotec.examen3Rest.examen3Rest.domain.Usuario;
import com.cenfotec.examen3Rest.examen3Rest.services.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/responsable"})
public class ResponsableController {

    @Autowired
    private ResponsableService responsableService;

    @GetMapping
    public List getAll(){
        return responsableService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Responsable> findById(@PathVariable long id){
        Optional<Responsable> result = responsableService.findById(id);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Responsable create(@RequestBody Responsable contact){
        return responsableService.save(contact).get();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Responsable> update(@PathVariable("id") long id,
                                          @RequestBody Responsable contact){
        contact.setId(id);
        Optional<Responsable> result = responsableService.update(contact);
        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value="/{idResponsable}/usuario/{idUsuario}")
    public ResponseEntity<Responsable> asignarResponsable(@PathVariable("idUsuario") long idUsuario,
                                                  @PathVariable("idResponsable") long idResponsable){

        Optional<Responsable> result = responsableService.asignarUsuario(idUsuario, idResponsable);

        if (result.isPresent()){
            return ResponseEntity.ok().body(result.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping(value="/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (responsableService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
