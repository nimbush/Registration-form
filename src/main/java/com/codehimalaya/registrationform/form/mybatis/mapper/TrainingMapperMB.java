package com.codehimalaya.registrationform.form.mybatis.mapper;

import com.codehimalaya.registrationform.form.model.Training;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrainingMapperMB {
    @Select("SELECT * FROM training WHERE student_id = #{studentId}")
    List<Training> getTrainingsByStudentId(Integer studentId);

    @Insert("INSERT INTO training (course, institute, time_period, student_id) " +
            "VALUES (#{course}, #{institute}, #{time_period}, #{student.id})")
    @Options(useGeneratedKeys = true, keyProperty = "trainingId")
    void insertTraining(Training training);
}
