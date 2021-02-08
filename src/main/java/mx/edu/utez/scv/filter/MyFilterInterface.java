package mx.edu.utez.scv.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class MyFilterInterface implements Filter{
	
	private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<String>(
            Arrays.asList("/app/mascota/index",
            		"/app/mascota/save",
            		"/app/mascota/edit/",
            		"/app/mascota/update",
            		"/app/mascota/delete",
            		"/app/mascota/create")));


	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Entrada al filtro...");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        
        /*String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        
        System.out.println("Current path:" + path);
        boolean allowedPath = ALLOWED_PATHS.contains(path);
        System.out.println("ALLOWED_PATHS: " + ALLOWED_PATHS);
        
        if (allowedPath) {
            //Evitar mostrar una pÃ¡gina antigua que habia sido accedida con una sesiÃ³n vÃ¡lida
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);

            chain.doFilter(request, response);
    } else {
    	*/
        response.setStatus(404);
        response.sendRedirect(request.getContextPath() + "/Error");
        
   
		
	}

	
}
