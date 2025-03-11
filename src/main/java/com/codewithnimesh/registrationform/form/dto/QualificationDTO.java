package com.codewithnimesh.registrationform.form.dto;

import com.codewithnimesh.registrationform.form.model.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@AllArgsConstructor
public class QualificationDTO {
    @NotBlank
    private String examination;

    @NotBlank
    private String board;

    @NotBlank
    private Double percentage;

    @NotBlank
    private Integer yearOfPassing;

    @NotBlank
    private Student student;
}
