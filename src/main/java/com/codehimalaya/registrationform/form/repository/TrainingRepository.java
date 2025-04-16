package com.codehimalaya.registrationform.form.repository;

import com.codehimalaya.registrationform.form.model.Training;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training ,Long> {
}
