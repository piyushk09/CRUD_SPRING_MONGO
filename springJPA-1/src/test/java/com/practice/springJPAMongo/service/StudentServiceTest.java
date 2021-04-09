package com.practice.springJPAMongo.service;

import com.practice.springJPAMongo.entity.Student;
import com.practice.springJPAMongo.mapper.StudentMapper;
import com.practice.springJPAMongo.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = { "com.practice.springJPAMongo.mapper" })
@EnableTransactionManagement
public class StudentServiceTest {

    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Before
    public void init()
    {
        studentService = new StudentService(studentRepository, studentMapper);
    }
    @Test
    public void getAllStudentsTest()
    {
        Mockito.when(studentRepository.findAll()).thenReturn(mockStudents());

        List<Student> response = studentService.getAllStudents();

        Assert.assertEquals(response.size(), 1);
    }

    @Test
    public void saveStudentTest_WhenStudentIsNotNull()
    {
        Mockito.when(studentRepository.findByFirstNameAndLastName("ABC", "1234")).thenReturn(mockStudent());
        String  response = studentService.saveStudent(mockStudent());
        Assert.assertNotNull(response);
        Assert.assertEquals(response, "ABC 1234");
        Mockito.verify(studentRepository, Mockito.times(1)).save(Mockito.any());
    }
    @Test
    public void saveStudentTest_WhenStudentIsNull()
    {
        Mockito.when(studentRepository.findByFirstNameAndLastName("ABC", "1234")).thenReturn(null);
        String  response = studentService.saveStudent(mockStudent());
        Assert.assertNotNull(response);
        Assert.assertEquals(response, "ABC 1234");
        Mockito.verify(studentRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void removeStudentTest()
    {
        Mockito.when(studentRepository.findByFirstName("ABC")).thenReturn(mockStudent());
        String  response = studentService.removeStudent("ABC");
        Assert.assertNotNull(response);
        Assert.assertEquals(response, "ABC 1234 deleted");
        Mockito.verify(studentRepository, Mockito.times(1)).delete(Mockito.any());
    }
    @Test
    public void removeStudentTest_WhenNoStudentExist()
    {
        Mockito.when(studentRepository.findByFirstName("ABC")).thenReturn(null);
        String  response = studentService.removeStudent("ABC");
        Assert.assertNotNull(response);
        Assert.assertEquals(response, "Error, Record doesn't exists!! Try again");
        Mockito.verify(studentRepository, Mockito.times(0)).delete(Mockito.any());
    }

    private Student mockStudent() {
        Student student = new Student();
        student.setFirstName("ABC");
        student.setLastName("1234");
        return student;
    }

    private List<Student> mockStudents() {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setFirstName("ABC");
        students.add(student);
        return students;
    }

}
