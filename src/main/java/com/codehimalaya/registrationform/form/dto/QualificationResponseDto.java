package com.codehimalaya.registrationform.form.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QualificationResponseDto {
    @NotBlank
    private String examination;

    @NotBlank
    private String board;

    @NotBlank
    private Double percentage;

    @NotBlank
    private Integer yearOfPassing;

    //    @Getter
//    @Setter
    private Integer studentId;
}
