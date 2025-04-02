package edu.jsp.OneToOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.OneToOne.entity.Person;
import edu.jsp.OneToOne.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping()
	public Person savePerson(@RequestBody Person p)
	{
		return personService.savePerson(p);
	}
	
	@GetMapping("/{id}")
	public Person getByPersonId(@PathVariable long id)
	{
		return personService.getByPersonId(id);
	}
	
	@PutMapping("/{id}")
	public String updateByPersonid(@PathVariable long id ,@RequestBody Person person)
	{
		return personService.updateByPersonId(id, person);
	}
	
	@DeleteMapping("/{id}")
	public String deletedByPersonId(@PathVariable long id)
	{
		return personService.deletedByPersonId(id);
	}
	
	@GetMapping("/search")
	public List<Person> getByPersonName(@RequestParam String name)
	{
		return personService.getByPersonName(name);
	}
}
