package com.lti.restDemo.bean;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


//controller
//@Controller
@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	
	
	
	@GetMapping(path="/helloWorld")
	public String helloWorld()
	{
		return "Hello World";
	}
	
	//hello-world bean
	@GetMapping(path="/helloWorldBean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Howdy Partner!!!");
	}
	
	@GetMapping(path="/helloWorld/path-variable/{name}")
	public HelloWorldBean helloWorldPath(@PathVariable String name)
	{
		return new HelloWorldBean (String.format("Howdy Partner!!! %s",name));
	}
	
	@GetMapping(path="/helloWorldInternationalized")
	public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language",required = false) Locale locale)
	{
		
		return messageSource.getMessage("good.morning.message",null,locale);
	}
	
	
	
}
