package com.codewithnimesh.registrationform.form.controller;


import com.codewithnimesh.registrationform.form.service.FormService;
import com.codewithnimesh.registrationform.form.dto.StudentDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/form/nimesh")
public class StudentController {

    private final FormService formService;
    public StudentController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping("/get")
    public List<StudentDTO> getForm() {
        return formService.getStudents();
    }

    @PostMapping("/post/student")
    public void postForm(@RequestBody StudentDTO studentDTO) {
        formService.register(studentDTO);
    }

}
