package mx.edu.utez.scv.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {
	
	@Bean
	public FilterRegistrationBean<MyFilterInterface> registrationBean(){
		
		FilterRegistrationBean<MyFilterInterface> registrationBean = new FilterRegistrationBean<>();
		
		registrationBean.setFilter(new MyFilterInterface());
		registrationBean.addUrlPatterns("/*");
		
		return registrationBean;
	}

}