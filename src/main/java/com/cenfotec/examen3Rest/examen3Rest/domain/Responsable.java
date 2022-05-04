package com.cenfotec.examen3Rest.examen3Rest.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Responsable{


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String cedula;
        private String direccion;
        private String telefonoPrimario;
        private String telefonoSecundario;


        @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(name = "usuarioId", referencedColumnName = "ID")
        private List<Usuario> usuario;

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario.add(usuario);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoPrimario() {
        return telefonoPrimario;
    }

    public void setTelefonoPrimario(String telefonoPrimario) {
        this.telefonoPrimario = telefonoPrimario;
    }

    public String getTelefonoSecundario() {
        return telefonoSecundario;
    }

    public void setTelefonoSecundario(String telefonoSecundario) {
        this.telefonoSecundario = telefonoSecundario;
    }
}
