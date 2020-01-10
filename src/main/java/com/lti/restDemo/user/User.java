package com.lti.restDemo.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the user")
public class User {

	@ApiModelProperty(notes = "auto-generated value")
	private Integer id;
	
	@Size(min = 2,message = "Name Should have atleast 2 char")
	@ApiModelProperty(notes = "Name Should have atleast 2 char")	
	private String name;
	
	
	@Past
	@ApiModelProperty(notes = "Birth date should not be the current date")
	private Date DOB;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", DOB=" + DOB + "]";
	}

	public User(Integer id, String name, Date dOB) {
		super();
		this.id = id;
		this.name = name;
		DOB = dOB;
	}
	
	protected User()
	{
		
	}
	
}
