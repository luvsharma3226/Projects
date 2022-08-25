package com.dailycodebuffer.spring.data.jpa.tutorial.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Person;

@Service
public interface IOptionalService {

	public List<Person> getPerson();
	
	public String savePerson() ;

	public ResponseEntity<?> getPerson(int id);
}
