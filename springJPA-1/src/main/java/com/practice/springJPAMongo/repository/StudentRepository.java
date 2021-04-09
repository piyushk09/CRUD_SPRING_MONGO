package com.practice.springJPAMongo.repository;

import com.practice.springJPAMongo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{
	
	List<Student> findAll();
	Student findByFirstName(String firstName);

	Student findByFirstNameAndLastName(String firstName, String lastName);

}
