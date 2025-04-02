package edu.jsp.Banking_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Banking_App.entity.User;
import edu.jsp.Banking_App.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public User getByUserId(@PathVariable long id)
	{
		return userService.getByUserId(id);
	}
	
	@PostMapping()
	public  User createNewUser(@RequestBody User user)
	{
		return userService.createNewUser(user);
	}
	
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable long id, @RequestBody  User newUser)
	{
		return userService.UpdateByUserId(id, newUser);
	}
	
	@DeleteMapping("/{id}")
	public String deleteByUserId(@PathVariable long id)
	{
		return userService.deleteByUserId(id);
	}
	
	@GetMapping("/search/{name}")
	public List<User> getByUserName(@PathVariable String name){
		return userService.getByUserName(name);
	}
}

