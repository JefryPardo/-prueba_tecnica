package com.prueba.app_conexion.service.bd;

import java.util.List;

import com.prueba.app_conexion.model.HistoricoConexion;
import com.prueba.app_conexion.repository.HistoricoConexionRepository;
import com.prueba.app_conexion.service.IHistoricoConexionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HistoricoConexionServiceJpa implements IHistoricoConexionService{

    @Autowired
    private HistoricoConexionRepository historicoConexionRepo;


    @Override
    public List<HistoricoConexion> buscarHistorialDispositivoConEstaRed(int redId) {
        return historicoConexionRepo.findByRed(redId);
    }
    
}
