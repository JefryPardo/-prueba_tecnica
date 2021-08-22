package com.prueba.app_conexion.repository;

import java.util.List;

import com.prueba.app_conexion.model.HistoricoDispositivo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoDispositivoRepository extends JpaRepository<HistoricoDispositivo,Integer>{
    
    List<HistoricoDispositivo> findByMac(String x);

}
