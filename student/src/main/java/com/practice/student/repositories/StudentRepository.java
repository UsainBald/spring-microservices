package com.practice.student.repositories;

import com.practice.student.entities.Student;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long> {
  List<Student> findAllBySchoolId(Integer schoolId);
}
