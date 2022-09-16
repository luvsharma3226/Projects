package com.dailycodebuffer.spring.data.jpa.tutorial.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dailycodebuffer.spring.data.jpa.tutorial.dto.StudentDto;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import com.dailycodebuffer.spring.data.jpa.tutorial.repository.StudentRepository;

@Service
@Transactional
@PropertySource("file:src/main/resources/multiple-db.properties")
public class StudentService {
	
	@Autowired
	private Environment env;

	@Value("${server.port}")
	private int serverPort;
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getStudents() {
		getDataFromProperties();
		return studentRepository.findAll();
	}

	public Student updateByPut(Long id, StudentDto st) {
//		Student s1 = studentRepository.findById(id).get();
//		s1.setFirstName(st.getFirstName());
//		s1.setLastName(st.getLastName());
		Student s1 = new Student();
		s1.setStudentId(4l);
		studentRepository.save(s1);
//		studentRepository.s
//		studentRepository.save
		return s1;
	}

	public Map<String, List<Student>> groupByStandard() {
		List<Student> students = studentRepository.findAll();
		Map<String, List<Student>> resultMap = new HashMap<>();
		for (int i = 0; i < students.size(); i++) {
			Student Student = students.get(i);
			List<Student> StudentSubList = resultMap.getOrDefault(Student.getStandard(), new ArrayList<Student>());
			StudentSubList.add(Student);
			resultMap.put(Student.getStandard(), StudentSubList);
		}
		return resultMap;
	}
	
	public void getDataFromProperties() {
		System.out.println("getting port from Environment = "+env.getProperty("server.port"));
		System.out.println("getting server port = "+ serverPort);
		
	}

}
