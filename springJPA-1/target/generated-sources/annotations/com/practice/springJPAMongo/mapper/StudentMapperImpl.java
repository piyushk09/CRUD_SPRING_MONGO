package com.practice.springJPAMongo.mapper;

import com.practice.springJPAMongo.entity.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-08T18:03:26+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student toNewStudent(Student oldStudent, Student newStudent) {
        if ( oldStudent == null ) {
            return null;
        }

        return newStudent;
    }
}
