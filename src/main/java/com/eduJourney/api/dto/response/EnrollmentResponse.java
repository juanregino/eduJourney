package com.eduJourney.api.dto.response;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponse {
  private UUID id;
  private LocalDate date;
  // private UserBasicResponse user;
  // private CourseBasicResponse course;
}
