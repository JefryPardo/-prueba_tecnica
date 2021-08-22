package com.prueba.app_conexion.service.bd;

import java.util.List;

import com.prueba.app_conexion.model.HistoricoDispositivo;
import com.prueba.app_conexion.repository.HistoricoDispositivoRepository;
import com.prueba.app_conexion.service.IHistoricoDispositivoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HistoricoDispositivoServiceJpa implements IHistoricoDispositivoService {

    @Autowired
    private HistoricoDispositivoRepository historicoDispositivoRepo;

    @Override
    public List<HistoricoDispositivo> buscarHistorialConexiones(String mac_id) {        
        return historicoDispositivoRepo.findByMac(mac_id);
    }

    
    
}
