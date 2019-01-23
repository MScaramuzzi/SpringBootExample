package com.space.scanner.alien.controller;

import org.springframework.web.bind.annotation.RestController;

import com.space.scanner.alien.bean.Planet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
	@Autowired
	Planet planet;
	
	@RequestMapping("/")
	 public String index() {
		 return "Greetings from " + planet.getGreetings() + "!";
	 }

}
