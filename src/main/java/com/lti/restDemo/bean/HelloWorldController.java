package com.lti.restDemo.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//controller
//@Controller
@RestController
public class HelloWorldController {

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
	
}
