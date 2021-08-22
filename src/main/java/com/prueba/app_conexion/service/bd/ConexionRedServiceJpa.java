package com.prueba.app_conexion.service.bd;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.prueba.app_conexion.model.ConexionRed;
import com.prueba.app_conexion.repository.ConexionRedRepository;
import com.prueba.app_conexion.service.IConexionRedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;

@Service
@Primary
public class ConexionRedServiceJpa implements IConexionRedService{

    @Autowired
    private ConexionRedRepository conexionRedRepo;

    @Override
    public List<ConexionRed> buscarTodas() {
        return conexionRedRepo.findAll();
    }

    @Override
    public ConexionRed buscarPorId(int idConexionRed) {
        Optional<ConexionRed> optional = conexionRedRepo.findById(idConexionRed);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
    }

    @Override
    public void guardar(ConexionRed conexion_red) {
        conexionRedRepo.save(conexion_red); 
    }

    @Override
    public List<ConexionRed> buscarDestacadas() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        conexionRedRepo.deleteById(id);  
    }
    
}
