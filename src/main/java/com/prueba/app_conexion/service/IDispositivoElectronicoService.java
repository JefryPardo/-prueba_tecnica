package com.prueba.app_conexion.service;
import java.util.List;

import com.prueba.app_conexion.model.DispositivoElectronico;

public interface IDispositivoElectronicoService {

    List<DispositivoElectronico> buscarTodas();
    DispositivoElectronico buscarPorId(int idDispositivoElectronico);
    void guardar( DispositivoElectronico dispositivoElectronico);
    List<DispositivoElectronico> buscarMac(String mac);
    void eliminar(Integer id);
    List<DispositivoElectronico> buscarPorConexionRed(int conexionRed);
    


}
