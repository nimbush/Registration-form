package com.codehimalaya.registrationform.form.controller;


import com.codehimalaya.registrationform.form.dto.*;
import com.codehimalaya.registrationform.form.mapper.StudentMapperRequest;
import com.codehimalaya.registrationform.form.repository.StudentRepository;
import com.codehimalaya.registrationform.form.service.QualificationService;
import com.codehimalaya.registrationform.form.service.StudentService;
import com.codehimalaya.registrationform.form.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student/form/")
public class StudentController {


    private final StudentService formService;
    private final QualificationService qualificationService;
    private final TrainingService trainingService;
    private final StudentRepository studentRepository;

//    public StudentController(StudentService formService, QualificationService qualificationService, TrainingService trainingService, StudentRepository studentRepository) {
//        this.formService = formService;
//        this.qualificationService = qualificationService;
//        this.trainingService = trainingService;
//        this.studentRepository = studentRepository;
//    }

    @GetMapping("/get")
    public List<StudentRequestDto> getForm() {
        return formService.getStudents();
    }

    @PostMapping("/post/student")
    public void postForm(@RequestBody StudentRequestDto studentRequestDto) {
        formService.register(studentRequestDto);
    }

    StudentMapperRequest studentMapperRequest;
    @GetMapping("/get/")
    public List <StudentDTO> getFullDetails(){
        return studentRepository.findAll().stream()
                .map(student -> {
                   StudentDTO studentDTO = studentMapperRequest.toDTo(student);
                   studentDTO.setQualification(
                           student.getQualification().stream()
                                   .map(qualification -> new QualificationDTO(
//                                           qualification.getQualificationId(),
                                           qualification.getExamination(),
                                           qualification.getBoard(),
                                           qualification.getPercentage(),
                                           qualification.getYearOfPassing(),
                                           qualification.getStudent().getId()
                                   ))
                                   .collect(Collectors.toList())
                   );
                   studentDTO.setTrainings(
                           student.getTraining()
                           .stream()
                           .map(training -> new TrainingDTO(
                                   training.getCourse(),
                                   training.getInstitute(),
                                   training.getTimePeriod(),
                                   training.getStudent().getId()
                           ))
                           .collect(Collectors.toList())
                   );
                   return studentDTO;
                })
                .toList();
    }

    @PostMapping("/post")
    public void postCompleteForm(@RequestBody CompleteFormDTO completeFormDTO){
        formService.register(completeFormDTO.getStudent());
        for (QualificationDTO qualificationDTO : completeFormDTO.getQualification()){
            qualificationService.registerQualification(qualificationDTO);
        }
        for (TrainingDTO trainingDTO : completeFormDTO.getTraining()){
            trainingService.registerTraining(trainingDTO);
        }
    }

    @PutMapping("/put/student")
    public void putStudent(@RequestParam Long oldAge, @RequestParam Long newAge){
        formService.updateAge(oldAge, newAge);
    }

    @DeleteMapping("/delete/student")
    public void deleteStudent(@RequestParam String email){
        formService.deleteUser(email);
    }

}
