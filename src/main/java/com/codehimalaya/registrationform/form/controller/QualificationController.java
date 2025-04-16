package com.codehimalaya.registrationform.form.controller;

import com.codehimalaya.registrationform.form.dto.QualificationDTO;
import com.codehimalaya.registrationform.form.service.QualificationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/form/")
public class QualificationController {

    private final QualificationService qualificationService;
    public QualificationController(QualificationService qualificationService) {
        this.qualificationService = qualificationService;
    }

    @GetMapping("/get/qualification")
    public List<QualificationDTO> register() {
        return qualificationService.getQualification();
    }

    @PostMapping(value = "/post/qualification",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void postForm(@RequestBody QualificationDTO qualificationDTO) {
        qualificationService.registerQualification(qualificationDTO);
    }

}
