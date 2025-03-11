package com.codewithnimesh.registrationform.form.controller;

import com.codewithnimesh.registrationform.form.dto.QualificationDTO;
import com.codewithnimesh.registrationform.form.service.QualificationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/form/nimesh")
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
