package edu.jsp.Employee_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Employee_app.entity.Employee;
import edu.jsp.Employee_app.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	 EmployeeService employeeService;
	
	@PostMapping("save")
	public Employee saveEmployee(@RequestBody Employee e)
	{
		return employeeService.saveEmployee(e); 
	}
}
