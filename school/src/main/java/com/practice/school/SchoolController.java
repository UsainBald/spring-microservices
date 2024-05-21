package com.practice.school;

import com.practice.school.entities.School;
import com.practice.school.repositories.SchoolRepository;
import com.practice.school.responses.FullSchoolResponse;
import com.practice.school.services.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
  private final SchoolService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody School school) {
    service.saveSchool(school);
  }

  @GetMapping
  public ResponseEntity<List<School>> findAllSchools() {
    return ResponseEntity.ok(service.findAllSchools());
  }

  @GetMapping("/with-students/{school-id}")
  public ResponseEntity<FullSchoolResponse> findAllStudentsBySchoolId(
      @PathVariable("school-id") Long schoolId
  ) {
    return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
  }
}
