package com.raza.sb3client.controller;

import com.raza.sb3client.model.Student;
import com.raza.sb3client.service.StudentClientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/students")
public class StudentClientController {

    @Autowired
    private StudentClientService studentClientService;

//    @GetMapping
//    List<Student> getAllStudents(){
//
//    }
}
