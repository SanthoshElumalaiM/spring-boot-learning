package edu.SpringBoot.Demo.controller;

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
	
	@RequestMapping(value="getSant",method = RequestMethod.GET)
	public String m2() {
		
		return "Hi this is Sant";
	}
	
	@RequestMapping(method=RequestMethod.GET,value="getId")
	
	public String m3(@RequestParam int id) {
		return "<h1> Id ="+id+"</h1>";
	}
}
