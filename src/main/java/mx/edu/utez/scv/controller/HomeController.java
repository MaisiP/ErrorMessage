package mx.edu.utez.scv.controller;

import java.io.IOException;

import javax.management.RuntimeErrorException;

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
	
	@GetMapping("/runtime")
	public void runTimeError() throws RuntimeException {
		throw new RuntimeException(); 
	}
	
	@GetMapping("/iosexception")
	public void iosexceptionError() throws IOException {
		throw new IOException(); 
	}
	
}
