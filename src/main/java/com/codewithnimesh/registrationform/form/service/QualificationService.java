package com.codewithnimesh.registrationform.form.service;

import com.codewithnimesh.registrationform.form.dto.QualificationDTO;
import com.codewithnimesh.registrationform.form.mapper.QualificationMapper;
import com.codewithnimesh.registrationform.form.model.Qualification;
import com.codewithnimesh.registrationform.form.repository.QualificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationService {
    private final QualificationRepository qualificationRepository;
    private final QualificationMapper qualificationMapping = new QualificationMapper();

    @Autowired
    public QualificationService(QualificationRepository qualificationRepository) {
        this.qualificationRepository = qualificationRepository;
    }

    public List<QualificationDTO> getQualification() {
        return qualificationRepository.findAll().
                stream().map(qualificationMapping::toDTO).toList();
    }

    public void registerQualification(QualificationDTO qualificationDTO) {
        Qualification qualification = qualificationMapping.toEntity(qualificationDTO);
//        Optional<Qualification> qualificationOptional = qualificationRepository
//                .findByExamination(qualification.getExamination());
//
//        if (qualificationOptional.isPresent()){
//            throw new IllegalStateException("Qualification already exists with this pk");
//        }
        qualificationRepository.save(qualification);
    }
}
