package com.practice.springJPAMongo.mapper;

import com.practice.springJPAMongo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

    Student toNewStudent(Student oldStudent,@MappingTarget Student newStudent);

}
