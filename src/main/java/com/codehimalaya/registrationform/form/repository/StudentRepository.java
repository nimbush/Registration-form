package com.codehimalaya.registrationform.form.repository;

import com.codehimalaya.registrationform.form.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.email = :email")
    Optional<Student> findByEmail(@Param("email") String email);

    @Modifying
    @Query("UPDATE Student s SET s.age = :newAge WHERE s.age = :oldAge")
    void UpdatedAge(@Param("oldAge") Long oldAge,@Param("newAge") Long newAge);

    @Modifying
    @Query("DELETE Student s where s.email= :email")
    void deleteUser(@Param("email") String email);
}
