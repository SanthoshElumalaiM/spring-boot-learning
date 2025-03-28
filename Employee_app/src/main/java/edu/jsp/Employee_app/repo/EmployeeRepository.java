package edu.jsp.Employee_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jsp.Employee_app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	//save(Employee e)
	//FindById(Long l)
	//findAll()
	//deleteById(Long l)
	
	Employee findByName(String name);
	
	//name parameter
	@Query(value="select e from Employee e where e.name like %:name%")
	List<Employee> fecthByName(@Param("name") String name);
}
