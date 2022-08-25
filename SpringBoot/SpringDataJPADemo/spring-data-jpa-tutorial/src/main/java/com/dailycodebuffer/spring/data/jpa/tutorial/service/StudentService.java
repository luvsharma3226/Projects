package com.dailycodebuffer.spring.data.jpa.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dailycodebuffer.spring.data.jpa.tutorial.dto.StudentDto;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import com.dailycodebuffer.spring.data.jpa.tutorial.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

//	public List<Student> getStudents() {
//		return studentRepository.findAll();
//	}

//	public Student updateByPut(Long id, StudentDto st) {
////		Student s1 = studentRepository.findById(id).get();
////		s1.setFirstName(st.getFirstName());
////		s1.setLastName(st.getLastName());
//		Student s1 = new Student();
//		s1.setStudentId(4l);
//		studentRepository.save(s1);
////		studentRepository.s
////		studentRepository.save
//		return s1;
//	}

	
	public String updateByPatch(StudentDto s) {
		studentRepository.save(s);
//		return s;
		return "hello";
	}
}
