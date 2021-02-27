package mx.edu.utez.scv.controller;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;




@ControllerAdvice // para el uso del exceptionhanlder
@Controller // para el uso del handler para errores de http
public class CustomErrorController implements ErrorController{

	@ExceptionHandler(value = { Throwable.class })
		    protected String handleConflict(Exception ex, Model model) {   
		
				String codigoError = null;
				
		        if (ex instanceof NullPointerException) {
		        	
		        	codigoError = "EPS201";
					
				}else if (ex instanceof NumberFormatException) {
					codigoError = "EPS202";
					
				}else if (ex instanceof IllegalArgumentException) {
					codigoError = "EPS203";
					
				}else if (ex instanceof RuntimeException) {
					codigoError = "EPS204";
					
				}else if (ex instanceof IllegalStateException) {
					codigoError = "EPS205";
					
				}else if (ex instanceof NoSuchMethodException) {
					codigoError = "EPS206";
					
				}else if (ex instanceof ClassCastException) {
					codigoError = "EPS207";
					
				}else if (ex instanceof Exception) {
					codigoError = "EPS208";
					
				}else if (ex instanceof ParseException) {
					codigoError = "EPS209";
					
				}else if (ex instanceof InvocationTargetException) {
					codigoError = "EPS210";
					
				}else {
					codigoError = "EPS211";
				}
		        
				//obtención de detalles omitiendo la clase.
		        String detalles = ex.getCause()==null ? "El servidor no añadió detalles" : ex.getCause().toString().split(":", 2)[1];
		        
		        System.out.println("Tipo de error: " + codigoError + " detalles: " + detalles);
				
		       
		        model.addAttribute("error",codigoError);
				return getErrorPath();
		    }
	
	 @RequestMapping("/error")
	 public String handleError(HttpServletRequest request, Model model) {
	        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
	        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
	        if (statusCode>=400&&statusCode<500) {
	        	model.addAttribute("error", "404");
			}else if (statusCode>=500) {
				model.addAttribute("error", "EPS211");
				System.out.print("error: EPS211"+ " detalles: " + "Error interno en el servidor");
			}
	        return getErrorPath();
	    }

	@Override
	public String getErrorPath() {
		return "error";
	}

}