package com.lti.restDemo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Repository;

@Repository
public class UserDaoService {

	private static int userCount=3;
	
	private static List<User> users=new ArrayList<>();
	
	static {
		
		users.add(new User(1, "Simon", new Date()));
		users.add(new User(2, "Mike", new Date()));
		users.add(new User(3, "Adam", new Date()));
	}
	
	
//	METHODS ON USERS
	public List<User> findall()
	{
		return users;
	}
	
   public User save(User user)
   {
	   if(user.getId()==null)
	   {
		   user.setId(++userCount);
	   }
	   users.add(user);
	   return user;
   }
	
   public User findOne(int id)
   {
	   
	   for(User user:users)
	   {
		   if(user.getId()==id)
			   return user;
	   }
	   
	   return null;
	   
   }
}
