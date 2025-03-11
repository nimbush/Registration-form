package com.codewithnimesh.registrationform.form.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Qualification {
    @Id
    @SequenceGenerator(
            name = "qualification_sequence",
            sequenceName = "qualification_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long qualificationId;

    private String examination;
    private String board;
    private Double percentage;
    private Integer yearOfPassing;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
