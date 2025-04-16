package com.codehimalaya.registrationform.form.mybatis.mapper;

import com.codehimalaya.registrationform.form.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapperMB {
//
//    @Select("SELECT * FROM student WHERE id = #{id}")
//    Student getStudentById(Integer id);

    @Select("SELECT * FROM student")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "fName", column = "f_name"),
            @Result(property = "lName", column = "l_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "age", column = "age"),
            @Result(property = "address", column = "address"),
            @Result(property = "city", column = "city"),
            @Result(property = "postal_code", column = "postal_code"),
            @Result(property = "state", column = "state"),
            @Result(property = "country", column = "country")
    })
    List<Student> getAllStudent();

    @Insert("INSERT INTO student (f_name, l_name, email, age, address, city, postal_code, state, country) " +
            "VALUES (#{f_name}, #{l_name}, #{email}, #{age}, #{address}, #{city}, #{postal_code}, #{state}, #{country})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertStudent(Student student);
}
