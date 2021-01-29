package mx.edu.utez.scv.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.utez.scv.entity.ExpedienteEntity;
import mx.edu.utez.scv.entity.MascotaEntity;
import mx.edu.utez.scv.entity.VeterinarioEntity;
import mx.edu.utez.scv.service.ExpedienteService;
import mx.edu.utez.scv.service.MascotaService;
import mx.edu.utez.scv.service.VeterinarioService;

@Controller
@RequestMapping("/app")
public class ExpedienteController {

	@Autowired
	private ExpedienteService service;
	@Autowired
	private MascotaService mascotaService;
	@Autowired
	private VeterinarioService veterinarioService;
	
	@GetMapping("/expediente/index")
	public String index(Model model) {
		model.addAttribute("expedientes",service.getAll());
		return "expediente/indexExpediente";
	}
	@GetMapping("/expediente/create")
	public String create(Model model) {
		
		model.addAttribute("expediente",new ExpedienteEntity());
		model.addAttribute("mascotas",mascotaService.getAll());
		model.addAttribute("veterinarios",veterinarioService.getAll());
		
		return "expediente/nuevaExpediente";
	}
	
	@RequestMapping(value = "/expediente/save", method = RequestMethod.POST)
	public String save (ExpedienteEntity expediente, Model model) {
		
		Calendar calendar = Calendar.getInstance();
		String fecha =calendar.get(Calendar.DATE)+ "-"+calendar.get(Calendar.MONTH)+"-"+calendar.get(Calendar.YEAR);
		
		MascotaEntity mascota = mascotaService.get(expediente.getMascota().getId());
		VeterinarioEntity veterinario = veterinarioService.get(expediente.getVeterinario().getId());
		expediente.setMascota(mascota);
		expediente.setVeterinario(veterinario);
		expediente.setFecha(fecha);
		
		service.add(expediente);
		return "redirect:index";
	}
}
