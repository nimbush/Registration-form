package com.codewithnimesh.registrationform.form.dto;

import com.codewithnimesh.registrationform.form.model.Qualification;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
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
    private List<Qualification> qualification;

}

