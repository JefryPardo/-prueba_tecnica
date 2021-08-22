package com.prueba.app_conexion.service.bd;

import java.util.List;
import java.util.Optional;

import com.prueba.app_conexion.model.DispositivoElectronico;
import com.prueba.app_conexion.repository.DispositivoElectronicoRepository;
import com.prueba.app_conexion.service.IDispositivoElectronicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
public class DispositivoElectronicoServiceJpa implements IDispositivoElectronicoService{

    @Autowired
    private DispositivoElectronicoRepository dispositivoElectronicoRepo;

    @Override
    public List<DispositivoElectronico> buscarTodas() {
        return dispositivoElectronicoRepo.findAll();
    }

    @Override
    public DispositivoElectronico buscarPorId(int idDispositivoElectronico) {
        Optional<DispositivoElectronico> optional = dispositivoElectronicoRepo.findById(idDispositivoElectronico);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
    }

    @Override
    public void guardar(DispositivoElectronico dispositivoElectronico) {
        dispositivoElectronicoRepo.save(dispositivoElectronico);    
    }

    @Override
    public List<DispositivoElectronico> buscarMac(String mac_id) {
        return dispositivoElectronicoRepo.findByMac(mac_id);
    }

    @Override
    public void eliminar(Integer id) {
        dispositivoElectronicoRepo.deleteById(id);    
    }

    @Override
    public List<DispositivoElectronico> buscarPorConexionRed(int conexionRed) {
        return dispositivoElectronicoRepo.findAllByConexionId(conexionRed);
    }

        

    
    
}
