package com.codewithnimesh.registrationform.form.mapper;

import com.codewithnimesh.registrationform.form.dto.QualificationDTO;
import com.codewithnimesh.registrationform.form.model.Qualification;

public class QualificationMapper {
    public  QualificationDTO toDTO(Qualification qualification) {
        return new QualificationDTO(
                qualification.getExamination(),
                qualification.getBoard(),
                qualification.getPercentage(),
                qualification.getYearOfPassing(),
                qualification.getStudent()
        );
    }

    public Qualification toEntity(QualificationDTO qualificationDTO) {
        Qualification qualification = new Qualification();
        qualification.setExamination(qualificationDTO.getExamination());
        qualification.setBoard(qualificationDTO.getBoard());
        qualification.setPercentage(qualificationDTO.getPercentage());
        qualification.setYearOfPassing(qualificationDTO.getYearOfPassing());
        qualification.setStudent(qualificationDTO.getStudent());
        return qualification;
    }
}
