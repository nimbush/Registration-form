package com.codehimalaya.registrationform.form.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompleteFormDTO {
    private StudentRequestDto student;
    private List<QualificationDTO> qualification;

    private List<TrainingDTO> training;

    public StudentRequestDto getStudent() {
        return student;
    }

    public void setStudent(StudentRequestDto student) {
        this.student = student;
    }

    public List<QualificationDTO> getQualification() {
        return qualification;
    }

    public void setQualification(List<QualificationDTO> qualification) {
        this.qualification = qualification;
    }

    public List<TrainingDTO> getTraining() {
        return training;
    }

    public void setTraining(List<TrainingDTO> training) {
        this.training = training;
    }
}
