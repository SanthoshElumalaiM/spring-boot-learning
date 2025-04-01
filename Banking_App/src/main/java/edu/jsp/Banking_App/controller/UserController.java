package edu.jsp.Banking_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Banking_App.entity.User;
import edu.jsp.Banking_App.repo.UserRepo;
import edu.jsp.Banking_App.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	//based on request type it will be excuted
	@GetMapping("/{id}")
	public User getById(@PathVariable long id)
	{
		return userService.getById(id);
	}
	
	//http://localhost/users
	@PutMapping()
	public User createNewUser(User user)
	{
		return userService.createNewUser(user);
	}
	
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable long id,User user)
	{
		return userService.updateUserById(id, user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable long id)
	{
		return userService.deleteById(id);
	}
	
	@GetMapping("/search")
	public List<User> getByUserName(@RequestParam String name)
	{
		return userService.getUserByName(name);
	}
	
	
	

}
