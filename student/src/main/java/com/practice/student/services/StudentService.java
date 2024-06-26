package com.practice.student.services;

import com.practice.student.entities.Student;
import com.practice.student.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public void saveStudent(Student student) {
    studentRepository.save(student);
  }

  public List<Student> findAllStudents() {
    return studentRepository.findAll();
  }

  public List<Student> findAllStudentsBySchool(Integer schoolId) {
    return studentRepository.findAllBySchoolId(schoolId);
  }

}
