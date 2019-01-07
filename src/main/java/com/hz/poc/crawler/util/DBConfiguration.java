package com.hz.poc.crawler.util;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DBConfiguration for inbuilt H2
 * 
 * @author vadivel
 * @version 1.0
 * @since 07/01/2019
 *
 */

@Configuration
public class DBConfiguration {

	@Bean
	ServletRegistrationBean<WebServlet> h2servletRegistration() {
		ServletRegistrationBean<WebServlet> registrationBean = new ServletRegistrationBean<WebServlet>(
				new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}

}
