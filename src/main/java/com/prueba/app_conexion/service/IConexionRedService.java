package com.prueba.app_conexion.service;

import java.util.List;
import com.prueba.app_conexion.model.ConexionRed;

public interface IConexionRedService {
    
    List<ConexionRed> buscarTodas();
    ConexionRed buscarPorId(int idConexionRed);
    void guardar( ConexionRed conexion_red);
    List<ConexionRed> buscarDestacadas();
    void eliminar(Integer id);
}
