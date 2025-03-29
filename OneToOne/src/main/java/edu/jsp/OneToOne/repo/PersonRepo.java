package edu.jsp.OneToOne.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.OneToOne.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
