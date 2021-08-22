package com.prueba.app_conexion.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table( name = "historico_conexiones" )
public class HistoricoConexion {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private int tipo;
    private String nombre_red;
    private String tipo_cifrado;
    private String usuario;
    private String mac;
    private String ip;
    private String tipo_dispositivo;
    private String motivo;
    private int red;
    private Date fecha_creacion;

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
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
    public String getMac() {
        return mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getTipo_dispositivo() {
        return tipo_dispositivo;
    }
    public void setTipo_dispositivo(String tipo_dispositivo) {
        this.tipo_dispositivo = tipo_dispositivo;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public int getRed() {
        return red;
    }
    public void setRed(int red) {
        this.red = red;
    }
    public Date getFecha_creacion() {
        return fecha_creacion;
    }
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }   
     
}
