package edu.SpringBoot.Demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
	
	
	@RequestMapping(value = "get")
	public String m1() {
		return "hi Sant";
	}
	
	@RequestMapping(value="getSant",method = RequestMethod.PUT)
	public String m2() {
		
		return "Hi this is Sant";
	}
	
	//it is used to map get request with handler method,and also it is common for all request method
	@RequestMapping(method=RequestMethod.GET,value="getId")
	
	public String m3(@RequestParam int id) {
		return "<h1> Id ="+id+"</h1>";
	}
	
	//it is used to map only getRequest with handler method
	//PostMapping -It is used to map only postRequest with handler method
	
	//@pathVariable -it is used to map with path
	@GetMapping("fetch/{id}/{name}")
	public String m4(@PathVariable int id,@PathVariable String name)
	{
		return "<h1> Id= "+id+", Name="+name+"</h1>";
	}
	
	
	@GetMapping("getStudent")
	public Student m5()
	{
		Student s=new Student();
		
		s.setId(1);
		s.setName("Sant");
		s.setAge(22);
		s.setMarks(429);
		
		return s;
		
	}
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student s)
	{
		System.out.println(s);
		return s;
	}
}
