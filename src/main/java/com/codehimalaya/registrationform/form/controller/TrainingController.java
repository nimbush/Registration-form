package com.codehimalaya.registrationform.form.controller;

import com.codehimalaya.registrationform.form.dto.QualificationDTO;
import com.codehimalaya.registrationform.form.dto.TrainingDTO;
import com.codehimalaya.registrationform.form.model.Training;
import com.codehimalaya.registrationform.form.service.TrainingService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/form/")
public class TrainingController {
    public TrainingService trainingService;
    public TrainingController(TrainingService trainingService){
        this.trainingService = trainingService;
    }

    @GetMapping("/get/training")
    public List<TrainingDTO> register() {
        return trainingService.getTraining();
    }

    @PostMapping(value = "/post/training",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postForm(@RequestBody TrainingDTO trainingDTO) {
        trainingService.registerTraining(trainingDTO);
    }
}
