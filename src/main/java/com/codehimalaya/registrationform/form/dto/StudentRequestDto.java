package com.codehimalaya.registrationform.form.dto;

import com.codehimalaya.registrationform.form.model.Qualification;
import com.codehimalaya.registrationform.form.model.Training;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    @NotBlank
    @JsonProperty(value = "fName")
    private String fname;

    @NotBlank
    @JsonProperty(value = "lName")
    private String lname;

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
}
