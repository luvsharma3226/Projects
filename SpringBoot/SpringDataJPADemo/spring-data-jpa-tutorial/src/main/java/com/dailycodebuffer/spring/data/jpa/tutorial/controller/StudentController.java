package com.dailycodebuffer.spring.data.jpa.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dailycodebuffer.spring.data.jpa.tutorial.dto.StudentDto;
import com.dailycodebuffer.spring.data.jpa.tutorial.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("get")
	public ResponseEntity<?> getStudent(){
		return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
	}
	
	
	@PutMapping("put/{id}")
	public ResponseEntity<?> updateStudentByPut(@PathVariable Long id, @RequestBody StudentDto studentDto){
		return new ResponseEntity<>(studentService.updateByPut(id,studentDto), HttpStatus.OK);
	}

	
	
	@GetMapping("group")
	public ResponseEntity<?> groupStuds(){
		return new ResponseEntity<>(studentService.groupByStandard(), HttpStatus.OK);
	}
	
	@GetMapping("groupwithStream")
	public ResponseEntity<?> groupStudswithstream(){
		return new ResponseEntity<>(studentService.groupByStandard(), HttpStatus.OK);
	}
	
//	@PatchMapping("patch/{id}")
//	public ResponseEntity<?> updateStudentByPatch(@RequestBody StudentDto s){
//		
//		return new ResponseEntity<>(studentService.updateByPatch(s), HttpStatus.OK);
//	}
}
