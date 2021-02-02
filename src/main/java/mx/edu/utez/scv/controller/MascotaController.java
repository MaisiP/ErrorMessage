package mx.edu.utez.scv.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.edu.utez.scv.entity.MascotaEntity;
import mx.edu.utez.scv.entity.PropietarioEntity;
import mx.edu.utez.scv.service.MascotaService;
import mx.edu.utez.scv.service.PropietarioService;

@Controller
@RequestMapping("/app")
public class MascotaController {
	
	@Autowired
	private MascotaService mascotaService;
	@Autowired
	private PropietarioService propietarioService;
	
	@GetMapping("/mascota/index")
	public String index(Model model) {
		
		model.addAttribute("mascotas", mascotaService.getAll());
		
		return "mascota/indexMascota";
	}
	
	@GetMapping("/mascota/create")
	public String create(Model model) {
		
		model.addAttribute("mascota", new MascotaEntity());
		
		return "mascota/nuevaMascota";
	}
	
	@RequestMapping (method= RequestMethod.POST, value= "/mascota/save")
	public String save(MascotaEntity mascota) {
		PropietarioEntity propietario = mascota.getPropietarioEntity();
		propietarioService.save(propietario);
		mascotaService.save(mascota);
		return "redirect:index";
	}
	
	@GetMapping("/mascota/edit/{id}")
	public String edit(@PathVariable long id, Model model) {
		
		model.addAttribute("mascota", mascotaService.get(id));
		
		return "mascota/editarMascota";
	}
	
	@RequestMapping (method= RequestMethod.POST, value= "/mascota/update")
	public String update(MascotaEntity mascota) {
		mascotaService.save(mascota);
		return "redirect:index";
	}
	
	@GetMapping("/mascota/delete/{id}")
	public String delete(@PathVariable long id, Model model) {
		
		mascotaService.delete(id);
		
		return "redirect:/app/mascota/index";
	}
	
	//Metodo para obtener informacion a traves de PathVariable
	@GetMapping("/mascota/show/{id}")
	public String shoW(@PathVariable int id, Model model) {

		model.addAttribute("mascota", mascotaService.get(id));
		
		return "mascota/show";
	}
	
	/*
	//Metodo para obtener informacion a traves de RequestParam
	@GetMapping("/mascota/show")
	public String show(@RequestParam int id, Model model) {
		
		List<Mascota> mascotas = new ArrayList<Mascota>();
		
		Mascota mascota = new Mascota(1,"Neko","Felino",5,true);
		mascotas.add(mascota);
		mascota = new Mascota(2,"ChimChim","Canino",1,true);
		mascotas.add(mascota);
		
		for (int i = 0; i < mascotas.size(); i++) {
			if(mascotas.get(i).getId()== id) {
				mascota = mascotas.get(i);
				break;
			}
		}
		
		model.addAttribute("mascota", mascota);
		
		return "mascota/show";
	}
	@GetMapping("/ejemploModelAndView")
	public ModelAndView modelAndView() {
		Mascota mascota = new Mascota(1,"Neko","Felino",5,true);
		ModelAndView model = new ModelAndView();
		model.addObject("mascota", mascota);
		model.setViewName("mascota/show");
		return model;
	}
	
	@RequestMapping("/anotacion")
	@ResponseBody
	public String anotacion() {
		return "Ejemplo Con requestMapping";
	}
	*/
	

}
