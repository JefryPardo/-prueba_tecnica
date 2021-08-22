package com.prueba.app_conexion.repository;

import java.util.List;

import com.prueba.app_conexion.model.DispositivoElectronico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DispositivoElectronicoRepository extends JpaRepository <DispositivoElectronico,Integer>{
    List<DispositivoElectronico> findByMac(String x);
    List<DispositivoElectronico> findAllByConexionId(int id);
}
