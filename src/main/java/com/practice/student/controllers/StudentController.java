package com.practice.student.controllers;

import com.practice.student.entities.Student;
import com.practice.student.services.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
  private final StudentService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody Student student) {
    service.saveStudent(student);
  }

  @GetMapping("/school/{school-id}")
  public ResponseEntity<List<Student>> findAllStudents(@PathVariable Integer schoolId) {
    return ResponseEntity.ok(service.findAllStudentsBySchool(schoolId));
  }
}
