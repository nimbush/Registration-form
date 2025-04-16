package com.codehimalaya.registrationform.form.mapper;

import com.codehimalaya.registrationform.form.dto.StudentDTO;
import com.codehimalaya.registrationform.form.dto.StudentRequestDto;
import com.codehimalaya.registrationform.form.model.Student;
import org.springframework.web.bind.annotation.Mapping;


public class StudentMapper {
    public StudentRequestDto toDTo(Student student) {
        return new StudentRequestDto(
                student.getFName(),
                student.getLName(),
                student.getEmail(),
                student.getAge(),
                student.getAddress(),
                student.getCity(),
                student.getCountry(),
                student.getPostalCode(),
                student.getState()
        );
    }

    public Student toEntity(StudentRequestDto studentRequestDto) {
        Student student = new Student();
        student.setFName(studentRequestDto.getFname());
        student.setLName(studentRequestDto.getLname());
        student.setEmail(studentRequestDto.getEmail());
        student.setAge(studentRequestDto.getAge());
        student.setAddress(studentRequestDto.getAddress());
        student.setCity(studentRequestDto.getCity());
        student.setCountry(studentRequestDto.getCountry());
        student.setPostalCode(studentRequestDto.getPostalCode());
        student.setState(studentRequestDto.getState());
        return student;
    }
}
