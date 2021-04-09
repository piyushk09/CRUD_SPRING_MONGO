package com.practice.springJPAMongo.controller;

import com.practice.springJPAMongo.entity.Student;
import com.practice.springJPAMongo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.practice.springJPAMongo.constants.UrlConstants.FETCH_STUDENTS;
import static com.practice.springJPAMongo.constants.UrlConstants.DELETE_STUDENT;
import static com.practice.springJPAMongo.constants.UrlConstants.SAVE_STUDENT;
import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

	private StudentService studentService;
	
	@GetMapping(value = FETCH_STUDENTS)
	public ResponseEntity<List<Student>> getAllStudents()
	{
		return new ResponseEntity<List<Student>>(studentService.getAllStudents(), HttpStatus.OK);
	}

	@PutMapping(value= SAVE_STUDENT)
	public ResponseEntity<String> saveStudent(@RequestBody Student student)
	{
		return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.OK);
	}

	@DeleteMapping(value = DELETE_STUDENT)
	public ResponseEntity<String> removeStudent(@RequestParam(value="firstName") String firstName)
	{
		return new ResponseEntity<>(studentService.removeStudent(firstName), HttpStatus.OK);
	}
}
