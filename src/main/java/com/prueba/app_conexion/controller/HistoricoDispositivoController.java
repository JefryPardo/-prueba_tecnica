package com.prueba.app_conexion.controller;

import java.util.List;

import com.prueba.app_conexion.model.HistoricoDispositivo;
import com.prueba.app_conexion.service.IHistoricoDispositivoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/historicoDispositivo")
public class HistoricoDispositivoController {
    
    @Autowired
    private IHistoricoDispositivoService serviceHistoricoDispositivo;


    @GetMapping("/view/{mac_id}")
	public String verDetaller(@PathVariable("mac_id") String mac_id, Model model) {//Parte dinamica de las variables en los enlaces
		
		List<HistoricoDispositivo> his = serviceHistoricoDispositivo.buscarHistorialConexiones(mac_id);
		model.addAttribute("historicoDispositivo", his);
		return "historicos/historicoDispositivos";
		
	}


}
