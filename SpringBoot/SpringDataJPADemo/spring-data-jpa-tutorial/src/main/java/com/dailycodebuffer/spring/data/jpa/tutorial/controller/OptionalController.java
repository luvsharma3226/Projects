package com.dailycodebuffer.spring.data.jpa.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dailycodebuffer.spring.data.jpa.tutorial.service.IOptionalService;

@Controller
@CrossOrigin("*")
@RequestMapping("optional")
public class OptionalController {

	@Autowired
	private IOptionalService optionalService;

	@PostMapping("getPerson")
	public ResponseEntity<?> getPerson() {
		return new ResponseEntity<>(optionalService.getPerson(), HttpStatus.OK);
	}
	

	@PostMapping("getPersonById/{id}")
	public ResponseEntity<?> getPerson(@PathVariable int id) {
		return new ResponseEntity<>(optionalService.getPerson(id), HttpStatus.OK);
	}
	
	
	@PostMapping("save")
	public ResponseEntity<?> savePerson() {
		return new ResponseEntity<>(optionalService.savePerson(), HttpStatus.OK);
	}
	
}
