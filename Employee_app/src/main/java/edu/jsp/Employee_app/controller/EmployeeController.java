package edu.jsp.Employee_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e)
	{
		Employee data= employeeService.saveEmployee(e); 
		return new ResponseEntity<Employee>(data, HttpStatus.OK);
	}
	
	@GetMapping("fetchById")
	public ResponseEntity<Employee> fetchById(@RequestParam long id)
	{
		Employee data= employeeService.fetchById(id);
		
		return new ResponseEntity<Employee>(data, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("fetchAll")
	public ResponseEntity<List<Employee>> fetchAll() {
		List<Employee> data= employeeService.fetchAll();
		if(data!=null)
		{
			return new ResponseEntity<List<Employee>>(data, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Employee>>( HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id)
	{
		String data= employeeService.deleteById(id);
		if(data!=null)
		{	
			return new ResponseEntity<String>(data, HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("updateSal")
	public ResponseEntity<String> updateById(@RequestParam long id,@RequestParam double sal)
	{
		return  new ResponseEntity<String>(employeeService.updateSal(id, sal), HttpStatus.OK) ;
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> update(@PathVariable Long  id,@RequestBody Employee newEmp)
	{
		return new ResponseEntity<String>( employeeService.update(id, newEmp), HttpStatus.OK) ;
	}
	
	@GetMapping("/findByName")
	public ResponseEntity<Employee> findByName(@RequestParam String name) {
		return new ResponseEntity<Employee>(employeeService.findByName(name), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/fetchByName")
	public ResponseEntity<List<Employee>>  fetchEmployee(@RequestParam String name)
	{
		return new ResponseEntity<List<Employee>>( employeeService.fetchByName(name), HttpStatus.OK);
	}
	
}

