package edu.jsp.Employee_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.Employee_app.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	//save(Employee e)
	//FindById(Long l)
	//findAll()
	//deleteById(Long l)
}
