package com.codehimalaya.registrationform.form.service;

import com.codehimalaya.registrationform.form.dto.QualificationDTO;
import com.codehimalaya.registrationform.form.mapper.QualificationMapper;
import com.codehimalaya.registrationform.form.model.Qualification;
import com.codehimalaya.registrationform.form.model.Student;
import com.codehimalaya.registrationform.form.repository.QualificationRepository;
import com.codehimalaya.registrationform.form.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationService {
    private final QualificationRepository qualificationRepository;
    private final QualificationMapper qualificationMapping = new QualificationMapper();
    private final StudentRepository studentRepository;

    @Autowired
    public QualificationService(QualificationRepository qualificationRepository, StudentRepository studentRepository) {
        this.qualificationRepository = qualificationRepository;
        this.studentRepository = studentRepository;
    }

    public List<QualificationDTO> getQualification() {
        return qualificationRepository.findAll().
                stream().map(qualificationMapping::toDTO).toList();
    }

    public void registerQualification(QualificationDTO qualificationDTO) {
//        Qualification qualification = qualificationMapping.toEntity(qualificationDTO);
//        Student student = studentRepository.findById(qualificationDTO.getStudentId())
//        Optional<Qualification> qualificationOptional = qualificationRepository
//                .findByExamination(qualification.getExamination());
//
//        if (qualificationOptional.isPresent()){
//            throw new IllegalStateException("Qualification already exists with this pk");
//        }
        Student student = studentRepository.findById(qualificationDTO.getStudentId())
                .orElseThrow(() -> new IllegalStateException("Student not found"));

        Qualification qualification = new Qualification();
        qualification.setExamination(qualificationDTO.getExamination());
        qualification.setBoard(qualificationDTO.getBoard());
        qualification.setPercentage(qualificationDTO.getPercentage());
        qualification.setYearOfPassing(qualificationDTO.getYearOfPassing());
        qualification.setStudent(student);

        qualificationRepository.save(qualification);
    }
}
