package com.codehimalaya.registrationform.form.mapper;

import com.codehimalaya.registrationform.form.dto.TrainingDTO;
import com.codehimalaya.registrationform.form.model.Training;

public class TrainingMapper {
    public TrainingDTO toDTo(Training training){
        return new TrainingDTO(
                training.getCourse(),
                training.getInstitute(),
                training.getTimePeriod(),
                training.getStudent() != null ? training.getStudent().getId() : null
        );
    }

    public Training toEntity(TrainingDTO trainingDTO){
        Training training = new Training();
        training.setCourse(trainingDTO.getCourse());
        training.setInstitute(trainingDTO.getInstitute());
        training.setTimePeriod(trainingDTO.getTimePeriod());
//        training.setStudentId(trainingDTO.getStudentId());
        return training;
    };
}
