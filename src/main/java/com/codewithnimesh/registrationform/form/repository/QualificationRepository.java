package com.codewithnimesh.registrationform.form.repository;

import com.codewithnimesh.registrationform.form.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
//    Optional <Qualification> findByExamination(String examination);
}
