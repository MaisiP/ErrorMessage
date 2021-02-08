package mx.edu.utez.scv.filter;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {
	
	@Bean
	public FilterRegistrationBean<MyFilterInterface> registrationBean(){
		
		FilterRegistrationBean<MyFilterInterface> registrationBean = new FilterRegistrationBean<>();
		
		
		registrationBean.setFilter(new MyFilterInterface());
		registrationBean.setUrlPatterns(Arrays.asList("/app/mascota/index*","/app/mascota/save*","/app/mascota/edit/[0-999]*","/app/mascota/update*","/app/mascota/delete*","/app/mascota/create*"));
		return registrationBean;
	}

}
