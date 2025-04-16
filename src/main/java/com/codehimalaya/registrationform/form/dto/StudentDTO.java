package com.codehimalaya.registrationform.form.dto;

import com.codehimalaya.registrationform.form.model.Qualification;
import com.codehimalaya.registrationform.form.model.Training;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    @NotBlank
    private String fName;

    @NotBlank
    private String lName;

    @Email
    private String email;


    @NotBlank
    private Integer age;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String state;

    @NotBlank
    private String country;

    @Valid
    private List<QualificationDTO> qualification;

    @Valid
    private List<TrainingDTO> trainings;

}

