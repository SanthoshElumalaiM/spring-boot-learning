package edu.jsp.Banking_App.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jsp.Banking_App.entity.User;

public interface UserRepo extends JpaRepository<User,Long > {

	@Query(value="select u from User u where u.name like %:name%")
	List<User> getUserByName(@Param("name") String name);
}
