package com.lti.restDemo.user;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.LinkBuilder;
import org.springframework.hateoas.server.core.LinkBuilderSupport;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.WebFluxBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.server.mvc.*;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.*;

@RestController
public class UserResource {

	
	@Autowired
	private UserDaoService uservice;
//	GET/users
//	Retrive all users resource
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		return uservice.findall();
	}
	
	
	
//	GET/users/{id}
//	Retrive users with id as Input
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id)
	{
		User user = uservice.findOne(id);
		if(user==null)
		throw new userNotFoundException("User Not Found for id "+id);

		EntityModel<User> resource=new EntityModel<User>(user);
		
		WebFluxBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		
//		@SuppressWarnings("deprecation")
//		Link link1=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		
		 
		
		resource.add((Iterable<Link>) linkTo.withRel("all-users"));
//		@SuppressWarnings("deprecation")
//		ControllerLinkBuilder linkTo=
//				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		
		

		//		res.add()
		
		return resource;
	}

	
//	created
//	input-details of user
//	output-created and return created uri

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid	 @RequestBody User user)
	{
		User saveUser=uservice.save(user);
//		created
//	/user/user.getId  saveduser.getId()
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	      
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		User user = uservice.deleteById(id);
		
		
		if(user==null)
		throw new userNotFoundException("User Not Found for id "+id);
		
		
//		return user;
	}
	
	
}