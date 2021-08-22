package com.prueba.app_conexion.controller;

import java.util.ArrayList;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DispositivoElectronicoController {

    @Autowired
    private IDispositivoElectronicoService serviceDispositivoElectronico;

	@Autowired
    private IConexionRedService serviceConexionRed;


    @GetMapping("/")
	public String MostrarHome(Model modelo) {
		List<DispositivoElectronico> lista = serviceDispositivoElectronico.buscarTodas();
		modelo.addAttribute("dispositivos", lista);
		return "index";
	}

	

	/**
	 *
	 * @param dispositivo
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String guardar(@ModelAttribute DispositivoElectronico dispositivo,Model model,RedirectAttributes attributes){
		
		List<DispositivoElectronico> dispositivoList = serviceDispositivoElectronico.buscarMac(dispositivo.getMac());
		System.out.println(dispositivoList.size());
		System.out.println(dispositivo.getId());
		if(dispositivoList.size() > 0 && dispositivo.getId() == 0){
			attributes.addFlashAttribute("msg", "Mac no disponible.  "+dispositivo.getMac());
			return "redirect:/create";	
		}else{
			serviceDispositivoElectronico.guardar(dispositivo);		
			attributes.addFlashAttribute("msg", "Dispositivo guardado.");
			return "redirect:/";
		}
		
	}


	
	/**
	 * 
	 * @param dipositivo
	 * @return
	 */
	@GetMapping("/create")
	public String crearDispositivo(DispositivoElectronico dipositivo,Model model,RedirectAttributes attributes) {	
		
		
		List<DispositivoElectronico> dispositivos = serviceDispositivoElectronico.buscarTodas();
		List<ConexionRed> redes = serviceConexionRed.buscarTodas();

		List<ConexionRed> newListRed = new ArrayList<ConexionRed>();  

		for (int i=0;i<redes.size();i++) { 
			int contador = 0;     
			for (int j=0;j<dispositivos.size();j++) {   
				if(redes.get(i).getId() == dispositivos.get(j).getConexion().getId()){
					contador+=1;
				}
			}
			if(contador < 3){
				newListRed.add(redes.get(i));
			}
		}
		
		if(newListRed.size() == 0){
			attributes.addFlashAttribute("msg","No hay redes disponibles, crea una nueva red.");	
			return "redirect:/";		
		}else{
			model.addAttribute("disponibles", newListRed);
			DispositivoElectronico dis = new DispositivoElectronico();
			model.addAttribute("dipositivo", dis);
			return "dispositivoElectronico/formDispositivoElectronico";				
		}
	}



	// @ModelAttribute
	// public String setGenericos(Model model){
			
	// }


	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idDispositivo, RedirectAttributes attributes) {
		
		serviceDispositivoElectronico.eliminar(idDispositivo);
			
		attributes.addFlashAttribute("msg", "El dispositivo fue eliminado!");
		return "redirect:/";
	}



	


	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idDispositivo, Model model,RedirectAttributes attributes) {
		
		List<DispositivoElectronico> dispositivos = serviceDispositivoElectronico.buscarTodas();
		List<ConexionRed> redes = serviceConexionRed.buscarTodas();

		List<ConexionRed> newListRed = new ArrayList<ConexionRed>();  

		for (int i=0;i<redes.size();i++) { 
			int contador = 0;     
			for (int j=0;j<dispositivos.size();j++) {   
				if(redes.get(i).getId() == dispositivos.get(j).getConexion().getId()){
					contador+=1;
				}
			}
			if(contador < 3){
				newListRed.add(redes.get(i));
			}
		}

		DispositivoElectronico dis = serviceDispositivoElectronico.buscarPorId(idDispositivo);
		if(dispositivos.size() == 0){
			for (int c=0;c<redes.size();c++) {   
				if(redes.get(c).getId() == dis.getConexion().getId()){
					newListRed.add(redes.get(c));		
				}
			}

			model.addAttribute("disponibles", newListRed);			
			model.addAttribute("dipositivo", dis);
			return "dispositivoElectronico/formDispositivoElectronico";	
		}else{
			boolean resp = false;
			for (int k=0;k<newListRed.size();k++) {   
				if(newListRed.get(k).getId() == dis.getConexion().getId()){
					resp = true;	
				}
			}


			if(resp){
				model.addAttribute("disponibles", newListRed);			
				model.addAttribute("dipositivo", dis);
				return "dispositivoElectronico/formDispositivoElectronico";
			}else{
				for (int c=0;c<redes.size();c++) {   
					if(redes.get(c).getId() == dis.getConexion().getId()){
						newListRed.add(redes.get(c));		
					}
				}
				
				model.addAttribute("disponibles", newListRed);			
				model.addAttribute("dipositivo", dis);
				return "dispositivoElectronico/formDispositivoElectronico";
			}
			
		}
	}


	



}
