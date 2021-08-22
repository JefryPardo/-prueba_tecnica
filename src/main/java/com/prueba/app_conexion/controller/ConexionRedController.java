package com.prueba.app_conexion.controller;

import java.util.List;

import com.prueba.app_conexion.model.ConexionRed;
import com.prueba.app_conexion.model.DispositivoElectronico;
import com.prueba.app_conexion.service.IConexionRedService;
import com.prueba.app_conexion.service.IDispositivoElectronicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/conexionRedController")
public class ConexionRedController {
    
    @Autowired
    private IConexionRedService serviceConexionRed;

	@Autowired
    private IDispositivoElectronicoService serviceDispositivoElectronico;

    @GetMapping("/vista")
	public String mostrarIndex(Model model) {
		List<ConexionRed> lista = serviceConexionRed.buscarTodas();
		model.addAttribute("conexionesRed", lista);
		return "conexionRed/homeConexionRed";
	}

	@GetMapping("/create")
	public String crearDispositivo(@ModelAttribute ConexionRed red,Model modelo,RedirectAttributes attributes) {	
		
		modelo.addAttribute("red", red);	
		return "conexionRed/formConexionRed";

	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute ConexionRed red,Model model,RedirectAttributes attributes){
		
		serviceConexionRed.guardar(red);		
		attributes.addFlashAttribute("msg", "Red guardada.");
		return "redirect:/conexionRedController/vista";
		
	}

	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idRed, RedirectAttributes attributes) {

		List<DispositivoElectronico> lista = serviceDispositivoElectronico.buscarPorConexionRed(idRed);
		if(lista.size() > 0){
			for (int j=0;j<lista.size();j++) {  
				serviceDispositivoElectronico.eliminar(lista.get(j).getId());
			}
			serviceConexionRed.eliminar(idRed);
		}else{
			serviceConexionRed.eliminar(idRed);		
		}

		attributes.addFlashAttribute("msg", "La conexion y sus dispositivos fueron eliminados.");
		return "redirect:/conexionRedController/vista";
		
	}


	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idConexionRed, Model model) {		
		ConexionRed con = serviceConexionRed.buscarPorId(idConexionRed);			
		model.addAttribute("red", con);
		return "conexionRed/formConexionRed";
	}
	


}
