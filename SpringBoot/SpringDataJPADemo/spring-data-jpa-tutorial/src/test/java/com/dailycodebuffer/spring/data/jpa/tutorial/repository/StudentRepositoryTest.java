package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository repository;

//	@Test
//	public void saveStudent() {
//		Student student = Student.builder().firstName("Kedar").lastName("Apet").emailId("kedar@gmail.com")
//				.guardianName("Amit").guardianEmail("anit@gmail.com").guardianMobile("8454875784").build();
//		repository.save(student);
//	}

//	@Test
//	public void saveStudentWithGuardian() {
//		
//		Guardian guardian = Guardian.builder().guardianName("Shantanu").guardianEmail("shaan@gmail.com").guardianMobile("45454654654").build();
//		Student student = Student.builder().firstName("Ajay").lastName("Patil").emailId("ajayp@gmail.com").guardian(guardian).build();
//				
//		repository.save(student);
//	}
//	
//	@Test
//	public void printStudents() {
//		List<Student> studentList = repository.findAll();
//		for (Student student : studentList) {
//			System.out.println(student.toString());
//		}

//	}

}
