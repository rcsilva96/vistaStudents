package com.crdtech.vistastudents_backend.controllers;

import com.crdtech.vistastudents_backend.models.Course;
import com.crdtech.vistastudents_backend.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.net.URI;

@RestController
@CrossOrigin
public class StudentController {

    private List<Student> students = new ArrayList<>();

//            Arrays.asList(new Student(1, "Renato", "renato@crdtech.com.br", "(11) 96171-7699", 1, 2),
//                                                   new Student(2, "Xiao", "xiao@crdtech.com.br", "(11) 98275-2428", 2, 3),
//                                                   new Student(3, "Amendoim", "amendoim@crdtech.com.br", "(11) 99999-9999", 3, 3)
//    );

    @GetMapping("students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {

        Student student = students.stream()
                          .filter (s -> s.getId() == id)
                          .findFirst()
                          .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Estudante não encontrado")
                          );

                          return ResponseEntity.ok(student);

    }

    @GetMapping("students")
    public List<Student> getStudents(){

        return students;

    }

    @PostMapping("students")
    public ResponseEntity<Student> save (@RequestBody Student student){

        student.setId(students.size() + 1);
        students.add(student);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(student.getId())
                .toUri();

        return ResponseEntity.created(location).body(student);

    }

}
