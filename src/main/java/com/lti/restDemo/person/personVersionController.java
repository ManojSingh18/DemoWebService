package com.lti.restDemo.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class personVersionController {

	
//	URI versioning
	@GetMapping("v1/person")
	public PersonV1 personV1()
	{
		return new PersonV1("Some1");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2()
	{
		String firstName="Charlie";
		String lastName="John";
		return new PersonV2(new Name(firstName, lastName));
	}
	
//	Versioned using request param
	@GetMapping(value = "person/param",params = "X-API-version=1")
	public PersonV1 personPramV1()
	{
		return new PersonV1("Some2");
	}
	
	
	@GetMapping(value = "person/param",params = "X-API-version=2")
	public PersonV2 personPramV2()
	{
		String firstName="Matt";
		String lastName="Colin";
		return new PersonV2(new Name(firstName, lastName));
	}
	
	
//	Versioned using request header
	@GetMapping(value = "person/header",headers = "version=1")
	public PersonV1 headerV1()
	{
		return new PersonV1("Some3");
	}
	
	
	@GetMapping(value = "person/header",headers =  "version=2")
	public PersonV2 headerV2()
	{
		String firstName="Andrew";
		String lastName="Mike";
		return new PersonV2(new Name(firstName, lastName));
	}
	
	
//	Versioned using request produces
	@GetMapping(value = "person/produces",produces =  "application/company1+json")
	public PersonV1 producesV1()
	{
		return new PersonV1("Some3");
	}
	
	
	@GetMapping(value = "person/produces",produces =   "application/company2+json")
	public PersonV2 producesV2()
	{
		String firstName="Andrew";
		String lastName="Mike";
		return new PersonV2(new Name(firstName, lastName));
	}
}
