package com.prueba.app_conexion.service;

import java.util.List;

import com.prueba.app_conexion.model.HistoricoConexion;

public interface IHistoricoConexionService {
    
    List<HistoricoConexion> buscarHistorialDispositivoConEstaRed(int redId);

}
