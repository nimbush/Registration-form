package com.codewithnimesh.registrationform.form.mapper;

import com.codewithnimesh.registrationform.form.dto.StudentDTO;
import com.codewithnimesh.registrationform.form.model.Student;

public class StudentMapper {
    public StudentDTO toDTo(Student student) {
        return new StudentDTO(
                student.getFName(),
                student.getLName(),
                student.getEmail(),
                student.getAge(),
                student.getAddress(),
                student.getCity(),
                student.getCountry(),
                student.getPostalCode(),
                student.getState(),
                student.getQualification()
        );
    }

    public Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFName(studentDTO.getFName());
        student.setLName(studentDTO.getLName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
        student.setAddress(studentDTO.getAddress());
        student.setCity(studentDTO.getCity());
        student.setCountry(studentDTO.getCountry());
        student.setPostalCode(studentDTO.getPostalCode());
        student.setState(studentDTO.getState());
        student.setQualification(studentDTO.getQualification());
        return student;
    }
}
