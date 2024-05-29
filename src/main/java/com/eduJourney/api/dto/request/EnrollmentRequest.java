package com.eduJourney.api.dto.request;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EnrollmentRequest {
  @FutureOrPresent(message = "Date cannot be in the past")
  @NotBlank(message = "Date cannot be blank")
  private LocalDate date;
  @NotNull(message = "User id cannot be null")
  @Min  (value = 1, message = "User id must be greater than 0")
  private UUID userId;
  @NotNull(message = "Course id cannot be null")
  @Min(value = 1, message = "Course id must be greater than 0")
  private UUID courseId;
}
