package com.codehimalaya.registrationform.form.mybatis.mapper;

import com.codehimalaya.registrationform.form.model.Qualification;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QualificationMapperMB {
    @Select("SELECT * FROM qualification WHERE student_id = #{studentId}")
    List<Qualification> getQualificationsByStudentId(Integer studentId);

    @Insert("INSERT INTO qualification (examination, board, percentage, year_of_passing, student_id) " +
            "VALUES (#{examination}, #{board}, #{percentage}, #{year_of_passing}, #{student.id})")
    @Options(useGeneratedKeys = true, keyProperty = "qualificationId")
    void insertQualification(Qualification qualification);

}
