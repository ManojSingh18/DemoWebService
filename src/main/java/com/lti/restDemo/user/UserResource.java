package com.lti.restDemo.user;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	 public User retrieveUser(@PathVariable int id) 
	 {
		 
	  User user = uservice.findOne(id);
	  if(user==null) 
	  throw new userNotFoundException("User Not Found for id "+id);
	 
//	  Resource<User> resource=new Resource<User>(user);
	  

	  
	 
	 // res.add()
	 return user;
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