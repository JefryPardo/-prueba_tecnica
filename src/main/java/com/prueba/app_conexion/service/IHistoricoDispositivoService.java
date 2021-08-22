package com.prueba.app_conexion.service;

import java.util.List;
import com.prueba.app_conexion.model.HistoricoDispositivo;

public interface IHistoricoDispositivoService {
    
    List<HistoricoDispositivo> buscarHistorialConexiones(String mac_id);
    
}
