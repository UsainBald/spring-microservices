package com.practice.school.services;

import com.practice.school.StudentClient;
import com.practice.school.entities.School;
import com.practice.school.repositories.SchoolRepository;
import com.practice.school.responses.FullSchoolResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
  private final SchoolRepository repository;
  private final StudentClient client;

  public void saveSchool(School school) {
    repository.save(school);
  }

  public List<School> findAllSchools() {
    return repository.findAll();
  }

  public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {
    var school = repository.findById(schoolId)
        .orElse(
            School.builder()
                .name("NOT FOUND")
                .email("NOT FOUND")
                .build()
        );
    var students = client.findAllStudentsBySchool(schoolId);
    return FullSchoolResponse.builder()
        .name(school.getName())
        .email(school.getEmail())
        .studends(students)
        .build();
  }
}
