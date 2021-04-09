package com.practice.springJPAMongo.controller;

import com.practice.springJPAMongo.entity.Student;
import com.practice.springJPAMongo.repository.StudentRepository;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.practice.springJPAMongo.mapper")
@SpringBootTest
public class StudentControllerTest {

    @Autowired
    private StudentRepository studentRepository;
    @Before
    public void init()
    {
        Student student = new Student();
        student.setFirstName("Piyush");
        student.setLastName("");
        studentRepository.save(student);
    }

    @After
    public void destroy()
    {
        studentRepository.deleteAll();
    }

    public void getAllStudentsTest()
    {
        //Mockito.when(studentRepository.findAll()).thenReturn(mockStudents());

//        Response response = given()
    }

    private List<Student> mockStudents() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setFirstName("Dummy");
        student.setLastName("");
        student.setGrade("A");
        student.setId("ABC123");
        students.add(student);
        return students;
    }

}
