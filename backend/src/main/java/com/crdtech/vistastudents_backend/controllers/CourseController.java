package com.crdtech.vistastudents_backend.controllers;

import com.crdtech.vistastudents_backend.models.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class CourseController {

    private List<Course> courses = Arrays.asList(new Course(1, "Java"),
                                                 new Course(2, "Angular"),
                                                 new Course(3, "Typescript")
    );

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable int id){

        Course course = courses.stream()
                        .filter( c -> c.getId() == id)
                        .findFirst()
                        .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Curso não encontrado")
                        );

        return ResponseEntity.ok(course);
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {

        return courses;

    }

}


