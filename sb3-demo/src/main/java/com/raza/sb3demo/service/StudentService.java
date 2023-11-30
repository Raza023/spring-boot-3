package com.raza.sb3demo.service;

import com.raza.sb3demo.model.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private ObservationRegistry observationRegistry;

    List<Student> studentList = new ArrayList<>();

    public Student addStudent(Student student) {
        studentList.add(student);
//        return student;
//        return Observation.createNotStarted("addStudent", observationRegistry)
//                .observe(() -> student);
        return (Student) observer("addStudent", student);
    }

    public List<Student> getAllStudents() {
//        return studentList;
        return (List<Student>) observer("getAllStudents", studentList);
    }

    public Student getStudent(String id) {
        Student myStudent =  studentList
                .stream()
                .filter(student -> student.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student is not available."));
//        return myStudent;
        return (Student) observer("getStudent", myStudent);
    }

    private Object observer(String type, Object object){
        return Observation.createNotStarted(type , observationRegistry)
                .observe(() -> object);
    }
}
