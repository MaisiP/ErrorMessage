package mx.edu.utez.scv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.utez.scv.entity.VeterinarioEntity;
import mx.edu.utez.scv.model.Veterinario;
import mx.edu.utez.scv.service.VeterinarioService;

@Controller
@RequestMapping("/app")
public class VeterinarioController {
	
	@Autowired
	private VeterinarioService service;
	
	@GetMapping("/veterinario/index")
	public String index(Model model) {
		
		model.addAttribute("veterinarios", service.getAll());
		return "veterinario/indexVeterinario";
	}
	
	@GetMapping("/veterinario/create")
	public String create(Model model) {
		
		model.addAttribute("veterinario", new Veterinario());
		return "veterinario/nuevoVeterinario";
	}
	
	@RequestMapping (method= RequestMethod.POST, value= "/veterinario/save")
	public String save(VeterinarioEntity veterinario) {
		service.save(veterinario);
		return "redirect:index";
	}
	
	@GetMapping("/veterinario/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		
		model.addAttribute("veterinario", service.get(id));
		return "veterinario/editarVeterinario";
	}
	
	@RequestMapping (method= RequestMethod.POST, value= "/veterinario/update")
	public String update(VeterinarioEntity veterinario) {
		service.save(veterinario);
		return "redirect:index";
	}
	
	@GetMapping("/veterinario/delete/{id}")
	public String delete(@PathVariable long id, Model model) {
		
		service.delete(id);
		return "redirect:/app/veterinario/index";
	}

}
