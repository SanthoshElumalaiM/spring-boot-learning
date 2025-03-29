package edu.jsp.OneToOne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.OneToOne.entity.Person;
import edu.jsp.OneToOne.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PutMapping("save")
	public Person save(@RequestBody Person p)
	{
		return personService.savePerson(p);
	}

}
