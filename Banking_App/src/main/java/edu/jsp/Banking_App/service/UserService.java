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
	private UserRepo userRepo;
	
	public User getByUserId(long id)
	{
		Optional<User> o= userRepo.findById(id);
		
		return o.isPresent()?o.get():null;
	}
	public User createNewUser(User user) {
		
		return userRepo.save(user);
	}
	public User UpdateByUserId(long id,User newUser) {
		
		User exUser= getByUserId(id);
		if(exUser!=null)
		{	
			newUser.setUid(id);
			 return userRepo.save(newUser);
		}
		return null;
		
	}
	
	public String deleteByUserId(long id)
	{
		User u= getByUserId(id);
		if(u!=null)
		{
			userRepo.delete(u);
			return "date deleted";
		}
		return "data not found";
	}
	
	public List<User> getByUserName(String  name)
	{
		return userRepo.getByUserName(name);
	}
}
