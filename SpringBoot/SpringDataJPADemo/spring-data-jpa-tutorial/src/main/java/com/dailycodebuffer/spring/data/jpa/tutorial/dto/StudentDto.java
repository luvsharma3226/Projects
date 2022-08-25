package com.dailycodebuffer.spring.data.jpa.tutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {
	private Long studentId;
	private String email;
//	private String firstName;
//
//	private String lastName;

	
}
