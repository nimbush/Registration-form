package com.codehimalaya.registrationform.form.mapper;

import com.codehimalaya.registrationform.form.dto.QualificationDTO;
import com.codehimalaya.registrationform.form.model.Qualification;

public class QualificationMapper {
    public  QualificationDTO toDTO(Qualification qualification) {
        return new QualificationDTO(
                qualification.getExamination(),
                qualification.getBoard(),
                qualification.getPercentage(),
                qualification.getYearOfPassing(),
                qualification.getStudent()!= null ? qualification.getStudent().getId() : null
        );
    }

    public Qualification toEntity(QualificationDTO qualificationDTO) {
        Qualification qualification = new Qualification();
        qualification.setExamination(qualificationDTO.getExamination());
        qualification.setBoard(qualificationDTO.getBoard());
        qualification.setPercentage(qualificationDTO.getPercentage());
        qualification.setYearOfPassing(qualificationDTO.getYearOfPassing());
//        qualification.setStudentId(qualificationDTO.getStudentId());
        return qualification;
    }
}
