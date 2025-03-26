package edu.jsp.Employee_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Employee_app.entity.Employee;
import edu.jsp.Employee_app.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee e)
	{
		return employeeRepository.save(e);
	}
	
	public Employee fetchById(long l)

	{
		Optional<Employee> o=employeeRepository.findById(l);
		
		if(o.isPresent())
		{
			return o.get();
		}
		return null;
	}
}
