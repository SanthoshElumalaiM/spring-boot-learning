package edu.jsp.Employee_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("fetchById")
	public Employee fetchById(@RequestParam long id)
	{
		return employeeService.fetchById(id);
	}
	
	@GetMapping("fetchAll")
	public List<Employee> fetchAll() {
		return employeeService.fetchAll();
	}
	
	@DeleteMapping("deleteById/{id}")
	public String deleteById(@PathVariable long id)
	{
		return employeeService.deleteById(id);
	}
	
	@PutMapping("updateSal")
	public String updateById(@RequestParam long id,@RequestParam double sal)
	{
		return employeeService.updateSal(id, sal);
	}
	
	@PutMapping("update/{id}")
	public String update(@PathVariable Long  id,@RequestBody Employee newEmp)
	{
		return employeeService.update(id, newEmp);
	}
	
	@GetMapping("/findByName")
	public Employee findByName(@RequestParam String name) {
		return employeeService.findByName(name);
	}
	
	@GetMapping("/fetchByName")
	public List<Employee> fetchEmployee(@RequestParam String name)
	{
		return employeeService.fetchByName(name);
	}
	
}

