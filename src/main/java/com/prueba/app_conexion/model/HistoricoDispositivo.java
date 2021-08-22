package com.prueba.app_conexion.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "historico_dispositivo" )
public class HistoricoDispositivo {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String mac;
    private String tipo;
    
    private Date fecha_creacion;
    private String ip;

    private String nombre_red;
    private String tipo_cifrado;
    private String usuario;
    private String motivo;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
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
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    } 

    



     
    
}
