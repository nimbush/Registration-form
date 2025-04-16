package com.codehimalaya.registrationform.form.dto;

import com.codehimalaya.registrationform.form.model.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class TrainingDTO {
    @NotBlank
    private String Course;

    @NotBlank
    private String Institute;

    @Positive
    private double TimePeriod;

//    @Getter
//    @Setter
    private Integer studentId;
}
