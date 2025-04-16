package com.codehimalaya.registrationform.form.service;

import com.codehimalaya.registrationform.form.dto.QualificationDTO;
import com.codehimalaya.registrationform.form.dto.TrainingDTO;
import com.codehimalaya.registrationform.form.mapper.TrainingMapper;
import com.codehimalaya.registrationform.form.model.Qualification;
import com.codehimalaya.registrationform.form.model.Student;
import com.codehimalaya.registrationform.form.model.Training;
import com.codehimalaya.registrationform.form.repository.StudentRepository;
import com.codehimalaya.registrationform.form.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper = new TrainingMapper();
    private final StudentRepository studentRepository;

    @Autowired
    public TrainingService (TrainingRepository trainingRepository, StudentRepository studentRepository){
        this.trainingRepository = trainingRepository;
        this.studentRepository = studentRepository;
    }

    public List<TrainingDTO> getTraining(){
        return trainingRepository.findAll().stream().map(trainingMapper::toDTo).toList();
    }

    public void registerTraining(TrainingDTO trainingDTO){
//        Training training = trainingMapper.toEntity(trainingDTO);
        Student student = studentRepository.findById(trainingDTO.getStudentId())
                .orElseThrow(() -> new IllegalStateException("Student not found"));

        Training training = new Training();
        training.setCourse(trainingDTO.getCourse());
        training.setInstitute(trainingDTO.getInstitute());
        training.setTimePeriod(trainingDTO.getTimePeriod());
        training.setStudent(student);
        trainingRepository.save(training);
    }
}
