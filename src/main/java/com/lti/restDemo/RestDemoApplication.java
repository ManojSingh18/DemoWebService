package com.lti.restDemo;

import java.util.Locale;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}
	
	
	@Bean
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver localeRes=new SessionLocaleResolver();
		localeRes.setDefaultLocale(Locale.US);
		return localeRes;
	}
	
//	@Bean
//	public ResourceBundleMessageSource resBound()
//	{
//		ResourceBundleMessageSource messSource=new ResourceBundleMessageSource();
//		messSource.setBasename("messages");
//		return messSource;
//	}

}
