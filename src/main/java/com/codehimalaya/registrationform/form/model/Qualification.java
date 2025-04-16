package com.codehimalaya.registrationform.form.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    @Column(name = "qualification_id")
    private Long qualificationId;

    private String examination;
    private String board;
    private Double percentage;

    @Column(name = "year_of_passing")
    private Integer yearOfPassing;

    @ManyToOne
    @JoinColumn(name = "student_id",referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Student student;
}

