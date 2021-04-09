package com.practice.springJPAMongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value="student")
public class Student {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String grade;
	
	

}
