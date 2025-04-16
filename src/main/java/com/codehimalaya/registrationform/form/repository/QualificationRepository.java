package com.codehimalaya.registrationform.form.repository;

import com.codehimalaya.registrationform.form.model.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Long> {
//    Optional <Qualification> findByExamination(String examination);
}
