package edu.jsp.OneToOne.service;

import java.util.List;
import java.util.Optional;

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

	public Person getByPersonId(long id)
	{
		Optional<Person> p= personRepo.findById(id);
		
		 return p.isPresent()?p.get():null;
	}
	
	public  String updateByPersonId  (long id,Person newPerson)
	{
		 Person exPerson= getByPersonId(id);
		 if(exPerson!=null)
		 {
			 newPerson.setId(id);
			  personRepo.save(newPerson);
			  return "data updated";
		 }
		 return "data not found";
	}
	
	public String deletedByPersonId(long id)
	{
		Person p= getByPersonId(id);
		if(p!=null)
		{
			personRepo.delete(p);
			return "data deleted";
			
		}
		return "data not found";
	}
	
	public List<Person> getByPersonName(String name)
	{
		return personRepo.getByPersonName(name);
	}
}
