package com.codewithnimesh.registrationform.form.service;

import com.codewithnimesh.registrationform.form.repository.StudentRepository;
import com.codewithnimesh.registrationform.form.model.Student;
import com.codewithnimesh.registrationform.form.dto.StudentDTO;
import com.codewithnimesh.registrationform.form.mapper.StudentMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {

    private final StudentRepository formRepository;
    private final StudentMapper studentMapping = new StudentMapper();
    private final StudentRepository studentRepository;

    @Autowired
    public FormService(StudentRepository formRepository, StudentRepository studentRepository) {
        this.formRepository = formRepository;
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getStudents() {
        return studentRepository.findAll().stream().map(studentMapping::toDTo).toList();
    }

    @Transactional
    public void register(StudentDTO studentDTO) {
        Student student = studentMapping.toEntity(studentDTO);
        Optional<Student> optionalStudentDTO = formRepository
                .findByEmail(student.getEmail());
        if (optionalStudentDTO.isPresent()){
            throw new IllegalStateException("Already exist");
        }
        formRepository.save(student);
    }

}
