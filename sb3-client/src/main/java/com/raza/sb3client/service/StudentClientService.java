package com.raza.sb3client.service;

import com.raza.sb3client.model.Student;
import java.util.List;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/students")
public interface StudentClientService {
    @GetExchange
    List<Student> getAllStudents();
}
