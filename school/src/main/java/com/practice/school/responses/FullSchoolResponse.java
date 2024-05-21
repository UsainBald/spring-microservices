package com.practice.school.responses;

import com.practice.school.entities.Student;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullSchoolResponse {
  private String name;
  private String email;
  List<Student> studends;
}
