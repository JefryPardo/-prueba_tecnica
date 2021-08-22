package com.prueba.app_conexion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "conexion_red" )
public class ConexionRed {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
    
    private String tipo;
    private String nombre_red;
    private String tipo_cifrado;
    private String usuario;
    private String contrasenia_conexion;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNombre_red() {
        return nombre_red;
    }
    public void setNombre_red(String nombre_red) {
        this.nombre_red = nombre_red;
    }
    public String getTipo_cifrado() {
        return tipo_cifrado;
    }
    public void setTipo_cifrado(String tipo_cifrado) {
        this.tipo_cifrado = tipo_cifrado;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasenia_conexion() {
        return contrasenia_conexion;
    }
    public void setContrasenia_conexion(String contrasenia_conexion) {
        this.contrasenia_conexion = contrasenia_conexion;
    }

    
}
