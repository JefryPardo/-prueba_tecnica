package com.prueba.app_conexion.controller;

import java.util.List;

import com.prueba.app_conexion.model.HistoricoConexion;
import com.prueba.app_conexion.model.HistoricoDispositivo;
import com.prueba.app_conexion.service.IHistoricoConexionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/historicoRed")
public class HistoricoConexionController {
    

    @Autowired
    private IHistoricoConexionService serviceHistoricoRed;

    @GetMapping("/view/{id}")
	public String verDetaller(@PathVariable("id") int idRed, Model model) {//Parte dinamica de las variables en los enlaces
		
		List<HistoricoConexion> his = serviceHistoricoRed.buscarHistorialDispositivoConEstaRed(idRed);
		model.addAttribute("historicoConexion", his);
		return "historicos/historicoConexiones";
		
	}

}
