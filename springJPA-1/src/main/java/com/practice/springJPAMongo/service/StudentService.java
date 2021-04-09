package com.practice.springJPAMongo.service;

import com.practice.springJPAMongo.entity.Student;
import com.practice.springJPAMongo.mapper.StudentMapper;
import com.practice.springJPAMongo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class StudentService {

	private StudentRepository studentRepository;
	private StudentMapper studentMapper;
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public String saveStudent(Student student)
	{
		Student oldStudent = studentRepository.findByFirstNameAndLastName(student.getFirstName(), student.getLastName());
		if(Objects.nonNull(oldStudent)) {
			studentRepository.save(studentMapper.toNewStudent(oldStudent, student));
		}
		else
		{
			studentRepository.save(student);
		}
		return student.getFirstName() +" " +student.getLastName();
	}

	public String removeStudent(String firstName) {
		Student student = studentRepository.findByFirstName(firstName);
		if(Objects.nonNull(student))
		{
			studentRepository.delete(student);
			return student.getFirstName() + " " + student.getLastName()+" deleted";
		}
		else
			return "Error, Record doesn't exists!! Try again";
	}
}
