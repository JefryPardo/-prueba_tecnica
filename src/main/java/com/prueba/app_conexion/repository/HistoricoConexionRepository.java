package com.prueba.app_conexion.repository;

import java.util.List;

import com.prueba.app_conexion.model.HistoricoConexion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoConexionRepository extends JpaRepository<HistoricoConexion,Integer> {
    List<HistoricoConexion> findByRed(int x);
}
