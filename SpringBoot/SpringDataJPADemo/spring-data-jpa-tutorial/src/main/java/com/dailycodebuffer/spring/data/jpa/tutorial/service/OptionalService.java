package com.dailycodebuffer.spring.data.jpa.tutorial.service;

import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Person;
import com.dailycodebuffer.spring.data.jpa.tutorial.repository.OptionalRepository;

@Service
@Transactional
public class OptionalService implements IOptionalService {

	@Autowired
	private OptionalRepository optionalRepository;

	@Override
	public List<Person> getPerson() {
		List<Person> people = optionalRepository.findAll();
		return people;
	}

	@Override
	public String savePerson() {
		Person p1 = Person.builder().mobile("9823329832").name("Shivam").build();
		Person p2 = Person.builder().mobile("323233232").name("Kishan").build();
		Person p3 = Person.builder().mobile("555555555").name("Luv").build();
		optionalRepository.save(p1);
		optionalRepository.save(p2);
		optionalRepository.save(p3);

		return "Saved Successfully!!!";
	}

	@Override
	public ResponseEntity<?> getPerson(int id) {
		Optional<Person> person = optionalRepository.findById(id);
//		person.ifPresentOrElse((p) -> System.out.println(p), () -> System.out.println("Person not presnt"));

		if (person.isPresent()) {
			Person p = person.get();
			Optional<String> up = Optional.ofNullable(p.getName());
			if (!up.isEmpty()) {
				System.out.println(up.get().toUpperCase());
			} else
				System.out.println("NAme is null");

			return new ResponseEntity<>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Person is not available with the id= " + id, HttpStatus.OK);
		}
	}

}
