package com.codehimalaya.registrationform.form.mybatis.service;

import com.codehimalaya.registrationform.form.model.Qualification;
import com.codehimalaya.registrationform.form.model.Student;
import com.codehimalaya.registrationform.form.model.Training;
import com.codehimalaya.registrationform.form.mybatis.mapper.QualificationMapperMB;
import com.codehimalaya.registrationform.form.mybatis.mapper.StudentMapperMB;
import com.codehimalaya.registrationform.form.mybatis.mapper.TrainingMapperMB;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceMB {
    @Autowired
    private StudentMapperMB studentMapper;

    @Autowired
    private QualificationMapperMB qualificationMapper;

    @Autowired
    private TrainingMapperMB trainingMapper;

    @Transactional
    public void registerFullStudent(Student student) {
        // Step 1: Save student and get ID
        studentMapper.insertStudent(student);

        // Step 2: Save qualifications
        if (student.getQualification() != null) {
            for (Qualification q : student.getQualification()) {
                q.setStudent(student);
                qualificationMapper.insertQualification(q);
            }
        }

        // Step 3: Save trainings
        if (student.getTraining() != null) {
            for (Training t : student.getTraining()) {
                t.setStudent(student);
                trainingMapper.insertTraining(t);
            }
        }
    }

    public List<Student> getAllStudentsWithDetails() {
        List<Student> students = studentMapper.getAllStudent();
        for (Student student : students) {
            student.setQualification(qualificationMapper.getQualificationsByStudentId(student.getId()));
            student.setTraining(trainingMapper.getTrainingsByStudentId(student.getId()));
        }
        return students;
    }
}
