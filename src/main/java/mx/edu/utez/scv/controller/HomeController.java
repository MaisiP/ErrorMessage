package mx.edu.utez.scv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class HomeController {

	@GetMapping({"/index","/","/home"})
	public String index (Model model) {
		model.addAttribute("saludo"," Bienvenido a nuestra Aplicación ");
		return "index";
	}
}
