package mx.edu.utez.scv.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
        System.out.print("error:" + exception.toString() + " codigo de error: " + statusCode.toString());
        if (statusCode>=400&&statusCode<500) {
        	model.addAttribute("numero", "página no encontrada, intenta de nuevo");
		}else if (statusCode>=500) {
			model.addAttribute("numero", "el server hizo algo mal xd");
		}
        
		/*
		 * return String.
		 * format("<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>" +
		 * "<div>Exception Message: <b>%s</b></div><body></html>", statusCode,
		 * exception==null? "N/A": exception.getMessage());
		 */
        return "Error";
        
    }

    @Override
    public String getErrorPath() {
        return "redirect:/app/";
    }
}