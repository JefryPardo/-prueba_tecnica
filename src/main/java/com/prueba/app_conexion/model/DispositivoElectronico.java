package com.prueba.app_conexion.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table( name = "dispositivo_electronico" )
public class DispositivoElectronico {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id; 


    private String mac;
    private String tipo;
    private boolean estado_conexion;

    @ManyToOne
    @JoinColumn( name = "conexion")
    private ConexionRed conexion;

    private String ip;

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

    public boolean isEstado_conexion() {
        return estado_conexion;
    }

    public void setEstado_conexion(boolean estado_conexion) {
        this.estado_conexion = estado_conexion;
    }

    public ConexionRed getConexion() {
        return conexion;
    }

    public void setConexion(ConexionRed conexion) {
        this.conexion = conexion;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

     
    
}
