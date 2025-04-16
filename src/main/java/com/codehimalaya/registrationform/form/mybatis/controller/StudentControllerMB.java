package com.codehimalaya.registrationform.form.mybatis.controller;

import com.codehimalaya.registrationform.form.model.Student;
import com.codehimalaya.registrationform.form.mybatis.service.FormServiceMB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentControllerMB {
    @Autowired
    private FormServiceMB formService;

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody Student student) {
        formService.registerFullStudent(student);
        return ResponseEntity.ok("Student registered successfully!");
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return formService.getAllStudentsWithDetails();
    }
}
