package com.codehimalaya.registrationform.form.service;

import com.codehimalaya.registrationform.form.dto.*;
import com.codehimalaya.registrationform.form.model.Qualification;
import com.codehimalaya.registrationform.form.repository.QualificationRepository;
import com.codehimalaya.registrationform.form.repository.StudentRepository;
import com.codehimalaya.registrationform.form.model.Student;
import com.codehimalaya.registrationform.form.mapper.StudentMapper;
import com.codehimalaya.registrationform.form.repository.TrainingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentMapper studentMapping = new StudentMapper();
    private final StudentRepository studentRepository;


//    @Autowired
//    public StudentService( StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    public List<StudentRequestDto> getStudents() {
        return studentRepository.findAll().stream().map(studentMapping::toDTo).toList();
    }

    @Transactional
    public void updateAge(Long oldAge, Long newAge){
        studentRepository.UpdatedAge(oldAge, newAge);
    }

    @Transactional
    public void deleteUser(String email){
        studentRepository.deleteUser(email);
    }

    @Transactional
    public void register(StudentRequestDto studentRequestDto) {
        Student student = studentMapping.toEntity(studentRequestDto);
//        Optional<Student> optionalStudentDTO = studentRepository
//                .findByEmail(student.getEmail());
//        if (optionalStudentDTO.isPresent()){
//            throw new IllegalStateException("Already exist");
//        }
        studentRepository.save(student);
    }
}
