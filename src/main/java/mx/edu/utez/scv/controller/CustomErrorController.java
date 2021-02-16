package mx.edu.utez.scv.controller;



import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class CustomErrorController  {

	@ExceptionHandler(value = { Exception.class })
		    protected String handleConflict(Exception ex, Model model) {
		        System.out.println("Error: " + ex.getClass());
		        
		        if (ex instanceof RuntimeException) {
					System.out.print("es de runtime");
					model.addAttribute("error", "5001");
					
				}else if (ex instanceof IOException) {
					System.out.print("es de IOException");
					model.addAttribute("error", "5002");
					
				}else {
					System.out.print("es otro");
					model.addAttribute("error", "8000");
				}
		        return "/error";
		    }
}