package edu.jsp.OneToOne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.OneToOne.entity.Person;
import edu.jsp.OneToOne.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;
	
	public Person savePerson(Person p)
	{
		return personRepo.save(p);
	}
	
}
