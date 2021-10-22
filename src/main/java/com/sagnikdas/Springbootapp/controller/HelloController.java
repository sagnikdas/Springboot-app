package com.sagnikdas.Springbootapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	//this is one way to do it. But we use @GetMapping
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	
	@GetMapping("/")
	public String helloWorld() {
		return "Welcome to Sagnik's First Spring App!!!!";
	}
}
