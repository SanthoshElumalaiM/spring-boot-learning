package edu.SpringBoot.Demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
	
	
	@RequestMapping(value = "get")
	public String m1() {
		return "hi Sant";
	}

}
