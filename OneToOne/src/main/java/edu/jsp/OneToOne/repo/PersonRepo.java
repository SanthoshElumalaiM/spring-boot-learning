package edu.jsp.OneToOne.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jsp.OneToOne.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {

	
	@Query(value="select p from Person p where p.name like %:name%")
	List<Person> getByPersonName(@Param("name") String name);
}
