package com.codehimalaya.registrationform.form.dto;

import com.codehimalaya.registrationform.form.model.Student;
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

//    @Getter
//    @Setter
    private Integer studentId;

}
