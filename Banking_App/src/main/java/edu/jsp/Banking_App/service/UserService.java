package edu.jsp.Banking_App.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Banking_App.entity.User;
import edu.jsp.Banking_App.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public User getById(long id)
	{
		Optional<User> o= userRepo.findById(id);
		
		 return o.isPresent()?o.get():null;
	}
	
	
	public User createNewUser(User user)
	{
		return userRepo.save(user);
	}
	
	public User updateUserById(long id,User newUser)
	{
		User exUser=getById(id);
		if(exUser!=null)
		{
			newUser.setUid(id);
			return userRepo.save(newUser);
		}
		return null;
	}
	
	public String deleteById(long id)
	{
		User u= getById(id);
		if(u!=null)
		{
			userRepo.delete(u);
			return "data deleted";
		}
		return "data not found";
		
	}
	
	public List<User> getUserByName(String name)
	{
		return userRepo.getUserByName(name);
	}

}
