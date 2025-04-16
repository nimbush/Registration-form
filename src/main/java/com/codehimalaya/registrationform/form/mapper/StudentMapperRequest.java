package com.codehimalaya.registrationform.form.mapper;

import com.codehimalaya.registrationform.form.dto.StudentDTO;
import com.codehimalaya.registrationform.form.model.Student;
import org.springframework.stereotype.Controller;

@Controller
public class StudentMapperRequest {
    public StudentDTO toDTo(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setFName(student.getFName());
        dto.setLName(student.getLName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());
        dto.setAddress(student.getAddress());
        dto.setCity(student.getCity());
        dto.setCountry(student.getCountry());
        dto.setPostalCode(student.getPostalCode());
        dto.setState(student.getState());
        return dto;
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
//        student.setQualification(studentDTO.getQualification());
//        student.setTrainings(studentDTO.getTrainings());
            return student;
        }
}
